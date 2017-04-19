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
    self.details = ko.observableArray();
    var region = window.sessionStorage.getItem("region");

    $.getJSON(window.env.ddApiBaseUrl + "/itsm-ddtalk/api/district/list", function(data) {
        if (data.status == "ok") {
            var diningRooms = [];
            $.each(data.data, function(i, d) {
                $.each(d.diningRomes, function(j, dr) {
                    if (region != null) {
                        if (region.toUpperCase() == d.districtName) {
                            diningRooms.push({
                                diningRoomId: dr.diningRoomId,
                                diningRoomName: dr.diningRoomName,
                                districtId: d.districtId,
                                districtName: d.districtName,
                                supProjectGroups: d.supProjectGroups
                            });
                        }
                    } else {
                        diningRooms.push({
                            diningRoomId: dr.diningRoomId,
                            diningRoomName: dr.diningRoomName,
                            districtId: d.districtId,
                            districtName: d.districtName,
                            supProjectGroups: d.supProjectGroups
                        });
                    }
                });
            });

            // 得到被选中服务站的id
            var serDeskIDs = [];
            $.ajaxSettings.async = false;
            $.getJSON(window.env.ddApiBaseUrl + '/itsm-ddtalk/api/store/desk_map', function(data1) {
                if (data1.status = "ok") {
                    $.each(data1.data, function(index, elem) {
                        serDeskIDs.push({
                            deskId: elem.serviceDeskId,
                            diningRoomId: elem.diningRoomId
                        });
                    });
                }
            });

            var serviceDesks = [];
            $.each(diningRooms, function(i, d) {
                $.each(d.supProjectGroups, function(j, p) {
                    $.each(p.serviceDesks, function(k, sd) {
                        $.each(serDeskIDs, function(index, ele) {
                            if (ele.deskId == sd.serviceDeskId & d.diningRoomId == ele.diningRoomId) {
                                serviceDesks.push({ serviceDeskId: sd.serviceDeskId, serviceDeskName: sd.serviceDeskName });
                            }
                        });
                    })
                });
                d.serviceDesks = serviceDesks;
                serviceDesks = [];
            });
            //console.log(diningRooms);
            self.details(diningRooms);
        }
    });
}

ko.components.register('yum-diningrooms-list', {
    template: `
        <div class="row">
          <section class="col-lg-12 connectedSortable">
            <div class="box box-primary">
              <div class="box-header">
                
              </div>
              <div class="box-body">
                <table id="issueTable" class="table table-bordered table-hover">
                  <thead>
                    <tr>
                      <th>No.</th>
                     <th>区域ID</th>
                      <th>区域名称</th>
                       <th>餐厅ID</th>
                       <th>餐厅名称</th>
                      <th>服务站</th>
                      <th>服务商</th>
                    </tr>
                  </thead>
                  <tbody data-bind="foreach: details">
                    <tr>
                      <td data-bind="text: $index() + 1"></td>
                      <td data-bind="text: districtId"></td>
                      <td data-bind="text: districtName"></td>
                      <td data-bind="text: diningRoomId"></td>
                      <td data-bind="text: diningRoomName"></td>
                      <td>
                      <ul class="list-unstyled" data-bind="foreach: serviceDesks">
                       <li data-bind="text: serviceDeskName"></li>
                      </ul>
                      </td>
                      <td>
                      <ul class="list-unstyled" data-bind="foreach: supProjectGroups">
                       <li data-bind="text: supProjectGroupName"></li>
                      </ul>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </section>
        </div>
    `,
    viewModel: createViewModel
});