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
function getdata(){
      $.ajax({
        url:'http://itsmpoc6341.cloudapp.net/itsm-ddtalk/api/store/list',
        type:'GET',
        dataType:'jsonp',
        async:true,
        success:function(data){
            return data;
        }
    });
}

function createViewModel() {
    var self =this;
     //var data=getdata();
     var areaData=[{"status":"ok","message":"","data":[{"diningRoomId":1,"diningRoomName":"星巴克世纪公园店","districtId":1,"serviceDesks":[]},{"diningRoomId":2,"diningRoomName":"肯德基陆家嘴店","districtId":2,"serviceDesks":[]}]}];
        // var areaJson=eval("("+areaData+")");
     self.details=[];
     self.rightCheckBoxData=[];
     $.each(areaData,function(indx,elem){
         $.each(elem.data,function(index1,elem1){
                 self.details.push({
                "diningRoomId":elem1.diningRoomId,
                "diningRoomName":elem1.diningRoomName,
                "districtId":elem1.districtId
            });
             });
        
         var supProjectGroupId;
        // 通过区域id查询服务商id，从而得到该服务商下面所有服务站
        //  $.getJSON("http://itsmpoc6341.cloudapp.net/itsm-ddtalk/api/district/vendor_map?id="+elem.districtId,function(data){
            if(1==1){
                var data='{"status":"ok","message":"","data":[{"districtGroupId":1,"districtId":1,"supProjectGroupId":1,"remark":""},{"districtGroupId":2,"districtId":1,"supProjectGroupId":2,"remark":""}]}';
             var json=eval("(" + data + ")");
            //  服务商id
                supProjectGroupId=json.data[0].supProjectGroupId;
                // 根据服务商id得到该服务商下面所有服务站
                // $.getJSON("http://itsmpoc6341.cloudapp.net/itsm-ddtalk/api/vendor/depts_ddtalk",function(data){
                    if(1==1){
                        var data1=[{"status":"ok","message":"","data":[{"supProjectGroupId":1,"supProjectGroupName":"乙服务商项目组","remark":"{\"id\":34467648,\"createDeptGroup\":false,\"name\":\"乙服务商项目组\",\"autoAddUser\":false,\"parentid\":34451581}","serviceDesks":[{"serviceDeskId":34432642,"serviceDeskName":"服务站D","supProjectGroupId":34467648,"remark":"{\"id\":34432642,\"createDeptGroup\":false,\"name\":\"服务站D\",\"autoAddUser\":false,\"parentid\":34467648}","empleeInfos":[{"empleeId":"344967551677734352","empleeName":"工程师d2","serviceDeskId":34432642,"remark":"{\"position\":\"\",\"remark\":\"\",\"department\":[34432642],\"unionid\":\"EiSiiopDKwQtUzEmzm54IfVgiEiE\",\"tel\":\"\",\"userid\":\"344967551677734352\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$YcDws7Ph+cidyvXPWU53Qg\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"344967551677734352\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师d2\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"15200000002\",\"openId\":\"EiSiiopDKwQtUzEmzm54IfVgiEiE\"}"},{"empleeId":"363526491677734351","empleeName":"工程师d1","serviceDeskId":34432642,"remark":"{\"position\":\"\",\"remark\":\"\",\"department\":[34432642],\"unionid\":\"gX5gh93Ch30zEmzm54IfVgiEiE\",\"tel\":\"\",\"userid\":\"363526491677734351\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$ngS1EsvlF3Vc8aAxq7TJkQ\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"363526491677734351\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师d1\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"15100000001\",\"openId\":\"gX5gh93Ch30zEmzm54IfVgiEiE\"}"}]},{"serviceDeskId":34432644,"serviceDeskName":"服务站C","supProjectGroupId":34467648,"remark":"{\"id\":34432644,\"createDeptGroup\":false,\"name\":\"服务站C\",\"autoAddUser\":false,\"parentid\":34467648}","empleeInfos":[{"empleeId":"123348661677734321","empleeName":"工程师c2","serviceDeskId":34432644,"remark":"{\"position\":\"\",\"remark\":\"\",\"department\":[34432644],\"unionid\":\"GRrxUo7OEaIiE\",\"tel\":\"\",\"userid\":\"123348661677734321\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$tXHt+gebtVGXFM6MnA9LZA\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"123348661677734321\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师c2\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"15300000000\",\"openId\":\"GRrxUo7OEaIiE\"}"},{"empleeId":"09375843041677734320","empleeName":"工程师c1","serviceDeskId":34432644,"remark":"{\"position\":\"\",\"remark\":\"\",\"department\":[34432644],\"unionid\":\"asIrHeVn1XvfXEHBL1KViPAiEiE\",\"tel\":\"\",\"userid\":\"09375843041677734320\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$Ikzm1GShAdA0FOAGnne5hw\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"09375843041677734320\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师c1\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"15400000010\",\"openId\":\"asIrHeVn1XvfXEHBL1KViPAiEiE\"}"},{"empleeId":"08546749411677734322","empleeName":"工程师c3","serviceDeskId":34432644,"remark":"{\"position\":\"\",\"remark\":\"\",\"department\":[34432644],\"unionid\":\"XU1AiSlX5riiGQ1niS9UAjJuQiEiE\",\"tel\":\"\",\"userid\":\"08546749411677734322\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$dFhTBBDFSztFPUJVUHLU0g\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"08546749411677734322\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师c3\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"15200000001\",\"openId\":\"XU1AiSlX5riiGQ1niS9UAjJuQiEiE\"}"}]}]},{"supProjectGroupId":34467649,"supProjectGroupName":"甲服务商项目组","remark":"{\"id\":34467649,\"createDeptGroup\":false,\"name\":\"甲服务商项目组\",\"autoAddUser\":false,\"parentid\":34451581}","serviceDesks":[{"serviceDeskId":34432643,"serviceDeskName":"服务站A","supProjectGroupId":34467649,"remark":"{\"id\":34432643,\"createDeptGroup\":false,\"name\":\"服务站A\",\"autoAddUser\":false,\"parentid\":34467649}","empleeInfos":[{"empleeId":"09375645211677734259","empleeName":"工程师a2","serviceDeskId":34432643,"remark":"{\"position\":\"\",\"remark\":\"\",\"department\":[34432643],\"unionid\":\"X9W4stXW2qWQ1niS9UAjJuQiEiE\",\"tel\":\"\",\"userid\":\"09375645211677734259\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$CDuU5046qnhKvb6PMdO8uw\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"09375645211677734259\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师a2\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"15400000005\",\"openId\":\"X9W4stXW2qWQ1niS9UAjJuQiEiE\"}"},{"empleeId":"09375644611677734258","empleeName":"工程师a1","serviceDeskId":34432643,"remark":"{\"position\":\"\",\"remark\":\"\",\"department\":[34432643],\"unionid\":\"juAdAece3TuQ1niS9UAjJuQiEiE\",\"tel\":\"\",\"userid\":\"09375644611677734258\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$TaqtMX2ZdrvPFMo9ZT4zNg\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"09375644611677734258\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师a1\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"15400000001\",\"openId\":\"juAdAece3TuQ1niS9UAjJuQiEiE\"}"},{"empleeId":"09375631061677734260","empleeName":"工程师a3","serviceDeskId":34432643,"remark":"{\"position\":\"\",\"remark\":\"\",\"department\":[34432643],\"unionid\":\"wFejiPmfWWNShAJH0JF0ZJwiEiE\",\"tel\":\"\",\"userid\":\"09375631061677734260\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$G/FrHD3Q7Nwb6b+m06r/+Q\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"09375631061677734260\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师a3\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"15400000003\",\"openId\":\"wFejiPmfWWNShAJH0JF0ZJwiEiE\"}"}]},{"serviceDeskId":34432645,"serviceDeskName":"服务站B","supProjectGroupId":34467649,"remark":"{\"id\":34432645,\"createDeptGroup\":false,\"name\":\"服务站B\",\"autoAddUser\":false,\"parentid\":34467649}","empleeInfos":[{"empleeId":"09375645281677734289","empleeName":"工程师b1","serviceDeskId":34432645,"remark":"{\"position\":\"\",\"remark\":\"\",\"department\":[34432645],\"unionid\":\"X9W4stXW2qWSx8FZjhiPRRQiEiE\",\"tel\":\"\",\"userid\":\"09375645281677734289\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$JARNYsHQnOoe9MvMBx3MZQ\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"09375645281677734289\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师b1\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"15400000006\",\"openId\":\"X9W4stXW2qWSx8FZjhiPRRQiEiE\"}"},{"empleeId":"09375618661677734290","empleeName":"工程师b2","serviceDeskId":34432645,"remark":"{\"position\":\"\",\"remark\":\"\",\"department\":[34432645],\"unionid\":\"lQjhSEEdQiiWhAJH0JF0ZJwiEiE\",\"tel\":\"\",\"userid\":\"09375618661677734290\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$0/LXZxNnn0cGpjpf+VQKDg\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"09375618661677734290\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师b2\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"15400000007\",\"openId\":\"lQjhSEEdQiiWhAJH0JF0ZJwiEiE\"}"}]}]}]}];
                    // var ogranize=eval("(" + data1 + ")");
                    $.each(data1[0].data,function(inx,ele){
                            //  $.each(ele1.data,function(inx1,ele){
                                window.console.log(ele);
                                // alert(typeof(ele.supProjectGroupId));
                                // alert(typeof(supProjectGroupId));
                        if(supProjectGroupId==ele.supProjectGroupId){
                            $.each(ele.serviceDesks,function(index,SerDeskEle){
                                self.rightCheckBoxData.push({
                                    "diningRoomId":elem.diningRoomId,
                                    "serviceDeskId":SerDeskEle.serviceDeskId,
                                    "serviceDeskName":SerDeskEle.serviceDeskName 
                                });
                            });
                        }
                            //  });
                
            });

                    };
            }
                // });

        //  });
           
     });

     self.leftDininginfo=ko.observableArray(self.details);
     self.rightSerDeskInfo=ko.observableArray(self.rightCheckBoxData);
}

ko.components.register('yum-diningRoomsAndDesks-list', {
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

