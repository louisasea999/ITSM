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
    self.diningRoomAndDesk = ko.observableArray();
    $.getJSON(window.env.ddApiBaseUrl + '/itsm-ddtalk/api/district/list', function(data) {
        if (data.status == "ok") {
            var diningRooms = [];
            $.each(data.data, function(i, d) {
                $.each(d.diningRomes, function(j, dr) {
                    diningRooms.push({
                        diningRoomId: dr.diningRoomId,
                        diningRoomName: dr.diningRoomName,
                        districtId: d.districtId,
                        districtName: d.districtName,
                        supProjectGroups: d.supProjectGroups
                    });
                });
            });
            var serviceDesks = [];
            $.each(diningRooms, function(i, d) {
                $.each(d.supProjectGroups, function(j, p) {
                    $.each(p.serviceDesks, function(k, sd) {

                        serviceDesks.push({ serviceDeskId: sd.serviceDeskId, serviceDeskName: sd.serviceDeskName, checked: false });
                    })
                });
                d.serviceDesks = serviceDesks;
                serviceDesks = [];
            });
            //console.log(diningRooms);

            $.getJSON(window.env.ddApiBaseUrl + '/itsm-ddtalk/api/store/desk_map', function(data) {
                if (data.status == "ok") {
                    $.each(data.data, function(i, d) {
                        $.each(diningRooms, function(j, dm) {
                            if (d.diningRoomId == dm.diningRoomId) {
                                $.each(dm.serviceDesks, function(k, sd) {
                                    if (sd.serviceDeskId == d.serviceDeskId) {
                                        sd.checked = true;
                                    }
                                })
                            }
                        })
                    })
                }
                //console.log(diningRooms);
                self.diningRoomAndDesk(diningRooms);
            });


        }
    });

    // 提交数据格式
    // data":[{"diningDeskId":1,"diningRoomId":1,"serviceDeskId":1,"remark":""},
    //        {"diningDeskId":2,"diningRoomId":2,"serviceDeskId":3,"remark":""}]

    self.submitData = function() {
        var roomDeskData = [];
        $.each(self.diningRoomAndDesk(), function(i, d) {
                $.each(d.serviceDesks, function(j, sd) {
                    if (sd.checked) {
                        roomDeskData.push({ diningDeskId: j, diningRoomId: d.diningRoomId, serviceDeskId: sd.serviceDeskId, remark: "" });
                    }
                })
            })
            //console.log(roomDeskData);
        $.ajax({
            type: "POST",
            url: window.env.ddApiBaseUrl + "/itsm-ddtalk/api/store/save_map",
            data: JSON.stringify(roomDeskData),
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




ko.components.register('yum-diningroomdesks-list', {
    template: `  
     <form class="form-inline">
       <table id="issueTable" class="table table-bordered table-hover">
                  <thead>
                    <tr>
                     <th>餐厅ID</th>
                      <th>餐厅名称</th>
                      <th>服务站</th>
                    </tr>
                  </thead>
                <tbody data-bind="foreach: diningRoomAndDesk">   
                    <tr>
                     <td data-bind="text: diningRoomId"></td>
                      <td data-bind="text: diningRoomName"></td>
                      <td>
                      <ul class="list-unstyled" data-bind="foreach: serviceDesks">
                         <li><input type="checkbox" data-bind="checked: checked" /><span data-bind="text: serviceDeskName"></span></li>
                      </ul>
                      </td>
                    </tr>
                  </tbody>
                </table>
        <button class="btn btn-primary pull-right" data-bind="click: submitData">提交</button>
    </form>
  
</form>
    `,
    viewModel: createViewModel
});