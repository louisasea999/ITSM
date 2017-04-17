// 去除数组中重复元素
unique = function (arr) {
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
    //var areaData=getareadata();
    var self = this;
    self.details = [];
    self.issues = ko.observableArray([]);
    // url:'http://itsmpoc6341.cloudapp.net/itsm-ddtalk/api/district/list',
    $.getJSON('http://itsmpoc6341.cloudapp.net/itsm-ddtalk/api/district/list', function (areaData) {
        console.log(areaData);
        //  self.datas =elem.data;
        $.each(areaData.data, function (index, dinEle) {
            self.details.push({
                "districtId": dinEle.districtId,
                "districtName": dinEle.districtName,
            });
        });
    });


    self.serviceinfo = [];
    //   url:'http://itsmpoc6341.cloudapp.net/itsm-ddtalk/api/vendor/depts_db',
    $.getJSON('http://itsmpoc6341.cloudapp.net/itsm-ddtalk/api/vendor/depts_db', function (serviceDate) {
        $.each(serviceDate.data, function (inx, serElm) {
            self.serviceinfo.push({
                "supProjectGroupId": serElm.supProjectGroupId,
                "supProjectGroupName": serElm.supProjectGroupName
            });
        });
        self.service = ko.observableArray(self.serviceinfo);
        self.uniqueDetail = unique(self.details);
        self.issues(self.uniqueDetail);
    });


    // 提交数据格式
    // data":[{"districtGroupId":1,"districtId":1,"supProjectGroupId":1,"remark":""},{"districtGroupId":2,"districtId":1,"supProjectGroupId":2,"remark":""}]

    $("#submitBtn").click(function () {
        var arr = [];
        var rowLen = self.issues().length;
        var colLen = self.service().length;

        self.data = [];
        for (var i = 1; i <= rowLen; i++) {
            for (var j = 0; j < colLen; j++) {
                console.log($('#subproj_' + i + "_" + j).attr('value'));

                //          data.push({
                //               "districtName":self.issues.districtId,
                //               "supProjectGroupId":$('#subproj_' + i + "_"  + j).attr('value')

                // });

            }
        }

        //  alert("hah");
        //  self.issue={
        //      "data":{
        //          districtGroupId:ko.observable("3"),
        //          districtName :ko.observable(''),
        //          supProjectGroupId:ko.observable(''),
        //          remark:""
        //      }
        //  };
        $.ajax({
            type: "POST",
            url: window.env.baseUrl + "/itsm-ddtalk/api/district/save_map",
            data: JSON.stringify(self.data),
            timeout: 30000,
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            },
            success: function (data) {

                alert("成功");
                window.location.href = "../../pages/ticket-list-area.html?page=areaList";
            },
            error: function (request, status, err) {
                alert("失败");

            }
        });
    });

}



ko.components.register('yum-area-list', {
    template: `  
     <form class="form-inline">
       <!-- <span data-bind="text: ko.toJSON(issues, null, 2)"></span>  -->
       <table id="issueTable" class="table table-bordered table-hover">
                  <thead>
                    <tr>
                     <th>区域id</th>
                      <th>区域名称</th>
                      <th>服务商</th>
                    </tr>
                  </thead>
                <tbody data-bind="foreach: issues">   
                    <tr>
                     <td name="districtId" data-bind="text: districtId"></td>
                      <td name="districtName" data-bind="text: districtName"></td>
                      <td data-bind="foreach:$parent.service">
                         <input type="checkbox"  data-bind="value:supProjectGroupId,attr:{id: 'subproj_' + $parent.districtId + '_' + $index()}"  />
                         <span data-bind="text: supProjectGroupName"></span>
                      </td>
                    </tr>
                  </tbody>
                </table>
        <button id="submitBtn" name="submitBtn"  class="btn">提交</button>
    </form>
    `,
    viewModel: createViewModel
});

