unique = function(arr){
    var res=[];
   for(var i =0;i<=arr.length-2;i++){
       for(var j=i+1;j<=arr.length-1;j++){
            if(arr[i].districtId==arr[j].districtId){
                break;
            }
            if(j==arr.length-1){
                res.push(arr[i]);
            }
       }
   }
   res.push(arr[arr.length-1]);
   return res;
}
function getAlldata(){
      var details=[];
      $.ajax({
        url:'http://itsmpoc6341.cloudapp.net/itsm-ddtalk/api/district/list',
        type:'GET',
        dataType:'jsonp',
        async:true,
        success:function(data){
        $.each(data.data,function(index,elem){
          var dinningRooms =elem.diningRooms;
          $.each(diningRooms,function(index,dinEle){
               details.push({
                "districtId":elem.districtId,
                "districtName":elem.districtName,
                "diningRoomId":dinEle.diningRoomId,
                "serviceDesk":'服务站',
                "serviceHost":'服务商'
            });
          })
        });

        }
    });
    return details;
}
function createViewModel() {
    //var data=getAlldata();
    var self=this;
    var data=[
      {"status":"ok","message":"","data":[{"districtId":1,"districtName":"世纪公园区域","supProjectGroups":[],"diningRomes":[{"diningRoomId":1,"diningRoomName":"星巴克世纪公园店","districtId":1,"serviceDesks":null}]},{"districtId":2,"districtName":"陆家嘴区域","supProjectGroups":[],"diningRomes":[{"diningRoomId":2,"diningRoomName":"肯德基陆家嘴店","districtId":2,"serviceDesks":null}]}]},
    {"status":"ok","message":"","data":[{"districtId":1,"districtName":"世纪公园区域","supProjectGroups":[],"diningRomes":[{"diningRoomId":1,"diningRoomName":"星巴克世纪公园店","districtId":1,"serviceDesks":null}]},{"districtId":2,"districtName":"陆家嘴区域","supProjectGroups":[],"diningRomes":[{"diningRoomId":2,"diningRoomName":"肯德基陆家嘴店","districtId":2,"serviceDesks":null}]}]},
    {"status":"ok","message":"","data":[{"districtId":1,"districtName":"世纪公园区域","supProjectGroups":[],"diningRomes":[{"diningRoomId":1,"diningRoomName":"星巴克世纪公园店","districtId":1,"serviceDesks":null}]},{"districtId":2,"districtName":"陆家嘴区域","supProjectGroups":[],"diningRomes":[{"diningRoomId":2,"diningRoomName":"肯德基陆家嘴店","districtId":2,"serviceDesks":null}]}]},
    {"status":"ok","message":"","data":[{"districtId":1,"districtName":"世纪公园区域","supProjectGroups":[],"diningRomes":[{"diningRoomId":1,"diningRoomName":"星巴克世纪公园店","districtId":1,"serviceDesks":null}]},{"districtId":2,"districtName":"陆家嘴区域","supProjectGroups":[],"diningRomes":[{"diningRoomId":2,"diningRoomName":"肯德基陆家嘴店","districtId":2,"serviceDesks":null}]}]} 
    //  {
    //         "key": "YUM-2",
    //         "keyHtml": "YUM-2",
    //         "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
    //         "summary": "Test issue 2",
    //         "summaryText": "Test issue 2"
    //     }
    ];
     self.details=[];
    $.each(data,function(index,elem){
         self.datas =elem.data;
           $.each(self.datas,function(index,dinEle){
             $.each(dinEle.diningRomes,function(index,dining){
                self.details.push({
                "districtId":dining.districtId,
                "districtName":dinEle.districtName,
                "diningRoomId":dining.diningRoomId,
                "diningRoomName":dining.diningRoomName,
                "serviceDesk":dining.serviceDesks,
                "serviceHost":'服务商'
            });
            });
           });
        });
     self.issues=ko.observableArray(unique(self.details));
     
}

ko.components.register('yum-diningRooms-list', {
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
                     <th>区域id</th>
                      <th>区域名称</th>
                       <th>餐厅id.</th>
                       <th>餐厅名称.</th>
                      <th>服务站</th>
                      <th>服务商</th>
                      <th>View/Edit</th> 
                    </tr>
                  </thead>
                  <tbody data-bind="foreach: issues">
                    <tr>
                      <td data-bind="text: $index() + 1"></td>
                      <td data-bind="text: districtId"></td>
                      <td data-bind="text: districtName"></td>
                      <td data-bind="text: diningRoomId"></td>
                      <td data-bind="text: diningRoomName"></td>
                      <td data-bind="text: serviceDesk"></td>
                      <td data-bind="text: serviceHost"></td>
                      <td>
                        <a href="./issueDetail.html"><i class="fa fa-edit"></i></a>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <div class="box-footer clearfix no-border">
                <button type="button" class="btn btn-default pull-right"><i class="fa fa-plus"></i> 创建事件</button>
              </div>
            </div>
          </section>
        </div>
    `,
    viewModel: createViewModel
});

