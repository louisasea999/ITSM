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
    var self = this;
    self.details = [];
    self.leftDininginfo = ko.observableArray([]);
    self.rightSerDeskInfo = ko.observableArray([]);
    $.getJSON('http://itsmpoc6341.cloudapp.net/itsm-ddtalk/api/store/list', function (areaData) {
        $.each(areaData.data, function (index, elem) {
            self.details.push({
                "diningRoomId": elem.diningRoomId,
                "diningRoomName": elem.diningRoomName,
                "districtId": elem.districtId
            });
            self.supProjectGroupId = [];
            // 通过区域id查询服务商id，从而得到该服务商下面所有服务站
            $.getJSON("http://itsmpoc6341.cloudapp.net/itsm-ddtalk/api/district/vendor_map?id=" + elem.districtId, function (data) {
                //  服务商id
                $.each(data.data, function (index3, ele3) {
                    self.supProjectGroupId.push({
                        "supProjectGroupId": ele3.supProjectGroupId,
                    });
                });
            });
            // 根据服务商id得到该服务商下面所有服务站
            $.getJSON("http://itsmpoc6341.cloudapp.net/itsm-ddtalk/api/vendor/depts_ddtalk", function (datas) {
                $.each(datas.data, function (inx, ele) {
                    window.console.log(ele);
                    $.each(self.supProjectGroupId, function (index4, ele4) {
                        if (ele4.supProjectGroupId == ele.supProjectGroupId) {
                            $.each(ele.serviceDesks, function (index, SerDeskEle) {
                                self.rightCheckBoxData.push({
                                    "diningRoomId": elem.diningRoomId,
                                    "serviceDeskId": SerDeskEle.serviceDeskId,
                                    "serviceDeskName": SerDeskEle.serviceDeskName
                                });
                            });
                        }
                    });

                    self.leftDininginfo(self.details);
                    self.rightSerDeskInfo(self.rightCheckBoxData);

                });
            });
        });
    });



}


ko.components.register('yum-diningroomdesks-list', {
    template: `  
     <form class="form-inline">
       <table id="issueTable" class="table table-bordered table-hover">
                  <thead>
                    <tr>
                     <th>餐厅id</th>
                      <th>餐厅名称</th>
                      <th>服务站</th>
                    </tr>
                  </thead>
                <tbody data-bind="foreach: leftDininginfo">   
                    <tr>
                     <td data-bind="text: diningRoomId"></td>
                      <td data-bind="text: diningRoomName"></td>
                      <td data-bind="foreach:$parent.rightSerDeskInfo">
                         <input type="checkbox" /><span data-bind=text:serviceDeskName></span>
                      </td>
                    </tr>
                  </tbody>
                </table>
        <button type="submit" class="btn">提交</button>
    </form>
  
</form>
    `,
    viewModel: createViewModel
});

