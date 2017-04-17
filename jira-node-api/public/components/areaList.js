// 去除数组中重复元素
/*unique = function(arr){
    var res=[];
   for(var i =0;i<arr.length-2;i++){
       for(var j=i+1;j<length;j++){
            if(arr[i]=a[j]){
                break;
            }
            if(j==arr.length-1){
                res.push(a[i]);
            }
       }
   }
   res.push(arr[length-1]);
   return res;
}*/
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
function getareadata(){
      $.ajax({
        url:'http://itsmpoc6341.cloudapp.net/itsm-ddtalk/api/district/list',
        type:'GET',
        dataType:'jsonp',
        async:true,
        success:function(data){
            return data;
        }
    });
}
function getServicedata(){
      var details=[];
      $.ajax({
        url:'http://itsmpoc6341.cloudapp.net/itsm-ddtalk/api/vendor/depts_db',
        type:'GET',
        dataType:'jsonp',
        async:true,
        success:function(data){
            return data;
        }
    });
}

function createViewModel() {
     //var areaData=getareadata();
    var self=this;
    var areaData=[
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
    $.each(areaData,function(index,elem){
         self.datas =elem.data;
           $.each(self.datas,function(index,dinEle){
                       self.details.push({
                        "districtId":dinEle.districtId,
                        "districtName":dinEle.districtName,
            });
           });
        });
    

     var serviceDate=[
         {"status":"ok","message":"","data":[{"supProjectGroupId":34467648,"supProjectGroupName":"乙服务商项目组","remark":"{\"id\":34467648,\"createDeptGroup\":false,\"name\":\"乙服务商项目组\",\"autoAddUser\":false,\"parentid\":34451581}","serviceDesks":[{"serviceDeskId":34432644,"serviceDeskName":"服务站C","supProjectGroupId":34467648,"remark":"{\"id\":34432644,\"createDeptGroup\":false,\"name\":\"服务站C\",\"autoAddUser\":false,\"parentid\":34467648}","empleeInfos":[{"empleeId":"08546749411677734322","empleeName":"工程师c3","serviceDeskId":34432644,"remark":"{\"position\":\"\",\"remark\":\"\",\"department\":[34432644],\"unionid\":\"XU1AiSlX5riiGQ1niS9UAjJuQiEiE\",\"tel\":\"\",\"userid\":\"08546749411677734322\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$dFhTBBDFSztFPUJVUHLU0g\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"08546749411677734322\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师c3\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"15200000001\",\"openId\":\"XU1AiSlX5riiGQ1niS9UAjJuQiEiE\"}"},{"empleeId":"09375843041677734320","empleeName":"工程师c1","serviceDeskId":34432644,"remark":"{\"position\":\"\",\"remark\":\"\",\"department\":[34432644],\"unionid\":\"asIrHeVn1XvfXEHBL1KViPAiEiE\",\"tel\":\"\",\"userid\":\"09375843041677734320\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$Ikzm1GShAdA0FOAGnne5hw\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"09375843041677734320\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师c1\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"15400000010\",\"openId\":\"asIrHeVn1XvfXEHBL1KViPAiEiE\"}"},{"empleeId":"123348661677734321","empleeName":"工程师c2","serviceDeskId":34432644,"remark":"{\"position\":\"\",\"remark\":\"\",\"department\":[34432644],\"unionid\":\"GRrxUo7OEaIiE\",\"tel\":\"\",\"userid\":\"123348661677734321\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$tXHt+gebtVGXFM6MnA9LZA\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"123348661677734321\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师c2\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"15300000000\",\"openId\":\"GRrxUo7OEaIiE\"}"}]},{"serviceDeskId":34432642,"serviceDeskName":"服务站D","supProjectGroupId":34467648,"remark":"{\"id\":34432642,\"createDeptGroup\":false,\"name\":\"服务站D\",\"autoAddUser\":false,\"parentid\":34467648}","empleeInfos":[{"empleeId":"363526491677734351","empleeName":"工程师d1","serviceDeskId":34432642,"remark":"{\"position\":\"\",\"remark\":\"\",\"department\":[34432642],\"unionid\":\"gX5gh93Ch30zEmzm54IfVgiEiE\",\"tel\":\"\",\"userid\":\"363526491677734351\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$ngS1EsvlF3Vc8aAxq7TJkQ\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"363526491677734351\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师d1\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"15100000001\",\"openId\":\"gX5gh93Ch30zEmzm54IfVgiEiE\"}"},{"empleeId":"344967551677734352","empleeName":"工程师d2","serviceDeskId":34432642,"remark":"{\"position\":\"\",\"remark\":\"\",\"department\":[34432642],\"unionid\":\"EiSiiopDKwQtUzEmzm54IfVgiEiE\",\"tel\":\"\",\"userid\":\"344967551677734352\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$YcDws7Ph+cidyvXPWU53Qg\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"344967551677734352\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师d2\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"15200000002\",\"openId\":\"EiSiiopDKwQtUzEmzm54IfVgiEiE\"}"}]}]},{"supProjectGroupId":34467649,"supProjectGroupName":"甲服务商项目组","remark":"{\"id\":34467649,\"createDeptGroup\":false,\"name\":\"甲服务商项目组\",\"autoAddUser\":false,\"parentid\":34451581}","serviceDesks":[{"serviceDeskId":34432645,"serviceDeskName":"服务站B","supProjectGroupId":34467649,"remark":"{\"id\":34432645,\"createDeptGroup\":false,\"name\":\"服务站B\",\"autoAddUser\":false,\"parentid\":34467649}","empleeInfos":[{"empleeId":"09375618661677734290","empleeName":"工程师b2","serviceDeskId":34432645,"remark":"{\"position\":\"\",\"remark\":\"\",\"department\":[34432645],\"unionid\":\"lQjhSEEdQiiWhAJH0JF0ZJwiEiE\",\"tel\":\"\",\"userid\":\"09375618661677734290\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$0/LXZxNnn0cGpjpf+VQKDg\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"09375618661677734290\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师b2\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"15400000007\",\"openId\":\"lQjhSEEdQiiWhAJH0JF0ZJwiEiE\"}"},{"empleeId":"09375645281677734289","empleeName":"工程师b1","serviceDeskId":34432645,"remark":"{\"position\":\"\",\"remark\":\"\",\"department\":[34432645],\"unionid\":\"X9W4stXW2qWSx8FZjhiPRRQiEiE\",\"tel\":\"\",\"userid\":\"09375645281677734289\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$JARNYsHQnOoe9MvMBx3MZQ\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"09375645281677734289\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师b1\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"15400000006\",\"openId\":\"X9W4stXW2qWSx8FZjhiPRRQiEiE\"}"}]},{"serviceDeskId":34432643,"serviceDeskName":"服务站A","supProjectGroupId":34467649,"remark":"{\"id\":34432643,\"createDeptGroup\":false,\"name\":\"服务站A\",\"autoAddUser\":false,\"parentid\":34467649}","empleeInfos":[{"empleeId":"09375631061677734260","empleeName":"工程师a3","serviceDeskId":34432643,"remark":"{\"position\":\"\",\"remark\":\"\",\"department\":[34432643],\"unionid\":\"wFejiPmfWWNShAJH0JF0ZJwiEiE\",\"tel\":\"\",\"userid\":\"09375631061677734260\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$G/FrHD3Q7Nwb6b+m06r/+Q\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"09375631061677734260\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师a3\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"15400000003\",\"openId\":\"wFejiPmfWWNShAJH0JF0ZJwiEiE\"}"},{"empleeId":"09375644611677734258","empleeName":"工程师a1","serviceDeskId":34432643,"remark":"{\"position\":\"\",\"remark\":\"\",\"department\":[34432643],\"unionid\":\"juAdAece3TuQ1niS9UAjJuQiEiE\",\"tel\":\"\",\"userid\":\"09375644611677734258\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$TaqtMX2ZdrvPFMo9ZT4zNg\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"09375644611677734258\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师a1\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"15400000001\",\"openId\":\"juAdAece3TuQ1niS9UAjJuQiEiE\"}"},{"empleeId":"09375645211677734259","empleeName":"工程师a2","serviceDeskId":34432643,"remark":"{\"position\":\"\",\"remark\":\"\",\"department\":[34432643],\"unionid\":\"X9W4stXW2qWQ1niS9UAjJuQiEiE\",\"tel\":\"\",\"userid\":\"09375645211677734259\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$CDuU5046qnhKvb6PMdO8uw\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"09375645211677734259\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师a2\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"15400000005\",\"openId\":\"X9W4stXW2qWQ1niS9UAjJuQiEiE\"}"}]}]}]}
    ];
    self.serviceinfo=[];
    $.each(serviceDate,function(index,ele){
        $.each(ele.data,function(inx,serElm){
            self.serviceinfo.push({
                "supProjectGroupId":serElm.supProjectGroupId,
                "supProjectGroupName":serElm.supProjectGroupName
        });
        });
    });

    self.service=ko.observableArray(self.serviceinfo);
    self.uniqueDetail=unique(self.details);
 self.issues=ko.observableArray(self.uniqueDetail);


// data":[{"districtGroupId":1,"districtId":1,"supProjectGroupId":1,"remark":""},{"districtGroupId":2,"districtId":1,"supProjectGroupId":2,"remark":""}]


 $("#submitBtn").click(function(){
    var arr = [];
    var rowLen = self.issues().length;
    var colLen = self.service().length;

    for(var i = 0;i < rowLen;i++) {
        for(var j = 0;j < colLen; j++) {
            console.log($('#subproj_' + i + "_"  + j).attr('value'));
        }
    }
    
    var data=[];
    data.push

     alert("hah");
     self.issue={
         "data":{
             districtGroupId:ko.observable("3"),
             districtName :ko.observable(''),
             supProjectGroupId:ko.observable(''),
             remark:""
         }
     };
    $.ajax({
                type: "POST",
                url: window.env.baseUrl + "/itsm-ddtalk/api/district/save_map",
                data: JSON.stringify(self.issue),
                timeout: 30000,
                headers: {
                    "Content-Type":"application/json; charset=utf-8"
                },
                success: function(data) {
                    // if(typeof data === object && data.hasOwnProperty('key')) {
                    //     alert('创建成功');
                    //     window.location.href = '/index.html'
                    // } else {
                    //     alert('创建失败');
                    //     self.sbmitBtnTxt(' 确认');
                    // }
                    alert("成功");
                    window.location.href="../../pages/ticket-list-area.html?page=areaList";
                },
                error: function(request, status, err) {
                    alert("失败");
                    self.sbmitBtnTxt(' 确认');
                    if(status == "timeout") {
                        alert('Error: Timeout');
                    } else {
                        alert('Error');
                    }
                }
            });
 });
 
}



ko.components.register('yum-area-list', {
    template: `  
     <form class="form-inline">
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

