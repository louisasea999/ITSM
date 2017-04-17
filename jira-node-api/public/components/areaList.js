// 去除数组中重复元素
unique = function(arr) {
    var res = [];
    for (var i = 0; i <= arr.length - 2; i++) {
        for (var j = i + 1; j <= arr.length - 1; j++) {
            if (arr[i].districtId == arr[j].districtId) {
                break;
            }
            if (j == arr.length - 1) {
                res.push(arr[i]);
            }
        }
    }
    res.push(arr[arr.length - 1]);
    return res;
}

function createViewModel() {
    var self = this;

    self.districtVendors = ko.observableArray();

    //var fakeDistricts = [{ "districtId": 1, "districtName": "世纪公园区域" }, { "districtId": 2, "districtName": "陆家嘴区域" }];
    //var fakeVendors = [{ "supProjectGroupId": 34587280, "supProjectGroupName": "甲服务商项目组" }, { "supProjectGroupId": 34612297, "supProjectGroupName": "乙服务商项目组" }];

    // var host = window.location.hostname;
    // if (host == "localhost") {
    //     self.districts(fakeDistricts);
    //     self.vendors(fakeVendors);
    // } else {
    //Get vendors
    $.getJSON(window.env.ddApiBaseUrl + "/itsm-ddtalk/api/vendor/depts_ddtalk", function(data) {
        if (data.status == "ok") {
            var vendors = [];
            //console.log(data.data);
            $.each(data.data, function(index, item) {
                vendors.push({ supProjectGroupId: item.supProjectGroupId, supProjectGroupName: item.supProjectGroupName, checked: false })
            });
            //Get districts
            $.getJSON(window.env.ddApiBaseUrl + "/itsm-ddtalk/api/district/list", function(data) {
                if (data.status == "ok") {
                    var districts = [];
                    $.each(data.data, function(index, item) {
                        districts.push({ districtId: item.districtId, districtName: item.districtName, vendors: jQuery.extend(true, [], vendors) })
                    });

                    //Get districts and vendors relationships
                    $.getJSON(window.env.ddApiBaseUrl + "/itsm-ddtalk/api/district/vendor_map", function(data) {
                        if (data.status == "ok") {
                            $.each(data.data, function(index, item) {
                                $.each(districts, function(i, d) {
                                    if (d.districtId == item.districtId) {
                                        $.each(d.vendors, function(j, v) {
                                            if (v.supProjectGroupId == item.supProjectGroupId) {
                                                v.checked = true;
                                            }
                                        })
                                    }
                                })
                            });


                            //console.log(districts);
                            self.districtVendors(districts);
                        }
                    });
                }
            });
        }
    });


    // }

    // 提交数据格式
    // data":[{"districtGroupId":1,"districtId":1,"supProjectGroupId":1,"remark":""},{"districtGroupId":2,"districtId":1,"supProjectGroupId":2,"remark":""}]

    self.submitData = function() {
        var arr = [];
        var rowLen = self.districtVendors().length;
        var colLen = self.districtVendors()[0].vendors.length;

        self.data = [
            // {"districtGroupId":1,"districtId":1,"supProjectGroupId":1,"remark":""},
            // {"districtGroupId":1,"districtId":1,"supProjectGroupId":2,"remark":""}
            // {"districtGroupId":1,"districtId":2,"supProjectGroupId":1,"remark":""},
            // {"districtGroupId":1,"districtId":2,"supProjectGroupId":2,"remark":""},
        ];
        for (var i = 1; i <= rowLen; i++) {
            for (var j = 0; j < colLen; j++) {
                var obj = document.getElementById('subproj_' + i + "_" + j);
                if (obj.checked === true) {
                    self.data.push({
                        "districtGroupId": 1,
                        "districtId": self.districtVendors()[i - 1]["districtId"],
                        "supProjectGroupId": self.districtVendors()[0].vendors[j]["supProjectGroupId"],
                        "remark": "checked"
                    })
                }
            }
        }

        //console.log(self.data);
        $.ajax({
            type: "POST",
            url: window.env.ddApiBaseUrl + "/itsm-ddtalk/api/district/save_map",
            data: JSON.stringify(self.data),
            timeout: 30000,
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            },
            success: function(data) {
                alert("更新成功.");
            },
            error: function(request, status, err) {
                alert("更新失败.");

            }
        });
    }


}



ko.components.register('yum-area-list', {
    template: `  
     <form class="form-inline">
       <!-- <span data-bind="text: ko.toJSON(districts, null, 2)"></span>  -->
       <table id="issueTable" class="table table-bordered table-hover">
                  <thead>
                    <tr>
                     <th>区域ID</th>
                      <th>区域名称</th>
                      <th>服务商</th>
                    </tr>
                  </thead>
                <tbody data-bind="foreach: districtVendors">   
                    <tr>
                     <td class="districtId" data-bind="text: districtId"></td>
                      <td class="districtName" data-bind="text: districtName"></td>
                      <td>
                      <ul class="list-unstyled" data-bind="foreach: vendors">
                      <li>
                         <input type="checkbox" data-bind="value:supProjectGroupId,checked:checked,attr:{id: 'subproj_' + $parent.districtId + '_' + $index()}" />
                         <span class="supProjectGroupName" data-bind="text: supProjectGroupName"></span>
                         </li>
                         </ul>
                      </td>
                    </tr>
                  </tbody>
                </table>
         <button class="btn btn-primary pull-right" data-bind="click: submitData">提交</button>
    </form>
    `,
    viewModel: createViewModel
});