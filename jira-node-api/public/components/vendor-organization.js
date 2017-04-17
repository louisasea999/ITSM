function organizationViewModel() {
    var self = this;
    self.vendorOrganization = ko.observableArray();
    self.employees = ko.observableArray();

    var fakeData = [{ "supProjectGroupId": 34587280, "supProjectGroupName": "甲服务商项目组", "remark": "{\"id\":34587280,\"createDeptGroup\":true,\"name\":\"甲服务商项目组\",\"autoAddUser\":true,\"parentid\":1}", "serviceDesks": [{ "serviceDeskId": 34614384, "serviceDeskName": "服务站B", "supProjectGroupId": 34587280, "remark": "{\"id\":34614384,\"createDeptGroup\":true,\"name\":\"服务站B\",\"autoAddUser\":true,\"parentid\":34587280}", "empleeInfos": [{ "empleeId": "055814271677733298", "empleeName": "工程师b2", "serviceDeskId": 34614384, "remark": "{\"position\":\"\",\"remark\":\"\",\"department\":[34614384],\"unionid\":\"vH85W2MPWrkiE\",\"tel\":\"\",\"userid\":\"055814271677733298\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$Gcn45d0aUvZaZ9ZER5au8g\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师b2\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"13482595760\",\"openId\":\"vH85W2MPWrkiE\"}" }, { "empleeId": "085939511677734289", "empleeName": "工程师b1", "serviceDeskId": 34614384, "remark": "{\"position\":\"\",\"remark\":\"\",\"department\":[34614384],\"unionid\":\"AMVsCrJFpJ8iE\",\"tel\":\"\",\"userid\":\"085939511677734289\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$UUVblbyI0FvJX3E105yGGA\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师b1\",\"active\":true,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"15618977302\",\"openId\":\"AMVsCrJFpJ8iE\"}" }] }, { "serviceDeskId": 34664321, "serviceDeskName": "服务站A", "supProjectGroupId": 34587280, "remark": "{\"id\":34664321,\"createDeptGroup\":true,\"name\":\"服务站A\",\"autoAddUser\":true,\"parentid\":34587280}", "empleeInfos": [{ "empleeId": "09412434081677734260", "empleeName": "工程师a3", "serviceDeskId": 34664321, "remark": "{\"position\":\"\",\"remark\":\"\",\"department\":[34664321],\"unionid\":\"dSt6wUOMwiiqJWm5V6tGmzAiEiE\",\"tel\":\"\",\"userid\":\"09412434081677734260\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$A9d0ChgsDHZfxlqnw7VyVg\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师a3\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"13452992347\",\"openId\":\"dSt6wUOMwiiqJWm5V6tGmzAiEiE\"}" }, { "empleeId": "09376264501677734259", "empleeName": "工程师a2", "serviceDeskId": 34664321, "remark": "{\"position\":\"\",\"remark\":\"\",\"department\":[34664321],\"unionid\":\"FPxRmQRjSgCiPiieGyReX5WAiEiE\",\"tel\":\"\",\"userid\":\"09376264501677734259\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$aMVVQqY6KKBUs6vuT1K9tA\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师a2\",\"active\":true,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"18616788416\",\"openId\":\"FPxRmQRjSgCiPiieGyReX5WAiEiE\"}" }, { "empleeId": "09461353061677734258", "empleeName": "工程师a1", "serviceDeskId": 34664321, "remark": "{\"position\":\"\",\"remark\":\"\",\"department\":[34664321],\"unionid\":\"BAH5PXjjKRHiSlU0q6zTiiRQiEiE\",\"tel\":\"\",\"userid\":\"09461353061677734258\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$x8V/CRl/AfA42UHzbGEMkQ\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师a1\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"18837396791\",\"openId\":\"BAH5PXjjKRHiSlU0q6zTiiRQiEiE\"}" }, { "empleeId": "09460334322688547", "empleeName": "Wang", "serviceDeskId": 34664321, "remark": "{\"position\":\"\",\"remark\":\"\",\"department\":[34664321],\"unionid\":\"xtiSDkiiaiPsey7QEB7fJgnBQiEiE\",\"tel\":\"\",\"userid\":\"09460334322688547\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$at6FKSEwpKo74BoOo1PFFQ\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"\",\"isBoss\":false,\"order\":\"17718750071243052\",\"email\":\"\",\"name\":\"Wang\",\"active\":true,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"18672335210\",\"openId\":\"xtiSDkiiaiPsey7QEB7fJgnBQiEiE\"}" }] }] }, { "supProjectGroupId": 34612297, "supProjectGroupName": "乙服务商项目组", "remark": "{\"id\":34612297,\"createDeptGroup\":true,\"name\":\"乙服务商项目组\",\"autoAddUser\":true,\"parentid\":1}", "serviceDesks": [{ "serviceDeskId": 34555361, "serviceDeskName": "服务站C", "supProjectGroupId": 34612297, "remark": "{\"id\":34555361,\"createDeptGroup\":true,\"name\":\"服务站C\",\"autoAddUser\":true,\"parentid\":34612297}", "empleeInfos": [{ "empleeId": "055817461677734321", "empleeName": "工程师c2", "serviceDeskId": 34555361, "remark": "{\"position\":\"\",\"remark\":\"\",\"department\":[34555361],\"unionid\":\"XyA1iPSNYN8wiE\",\"tel\":\"\",\"userid\":\"055817461677734321\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$7iwi0PHKiWS6HkaxblYPeg\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师c2\",\"active\":true,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"13917788116\",\"openId\":\"XyA1iPSNYN8wiE\"}" }, { "empleeId": "09346621101677734320", "empleeName": "工程师c1", "serviceDeskId": 34555361, "remark": "{\"position\":\"\",\"remark\":\"\",\"department\":[34555361],\"unionid\":\"BViSoFKrY6BiPiPiieGyReX5WAiEiE\",\"tel\":\"\",\"userid\":\"09346621101677734320\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$7XA3ZvZbt+q131RLcMrhng\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师c1\",\"active\":true,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"17717583504\",\"openId\":\"BViSoFKrY6BiPiPiieGyReX5WAiEiE\"}" }] }, { "serviceDeskId": 34636338, "serviceDeskName": "服务站D", "supProjectGroupId": 34612297, "remark": "{\"id\":34636338,\"createDeptGroup\":true,\"name\":\"服务站D\",\"autoAddUser\":true,\"parentid\":34612297}", "empleeInfos": [{ "empleeId": "09461368591677734351", "empleeName": "工程师d1", "serviceDeskId": 34636338, "remark": "{\"position\":\"\",\"remark\":\"\",\"department\":[34636338],\"unionid\":\"NU8YZjiPfNtCAkOjJskpWfwiEiE\",\"tel\":\"\",\"userid\":\"09461368591677734351\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$8PPnFv3NeIvnLC2nPOi12A\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师d1\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"13601779563\",\"openId\":\"NU8YZjiPfNtCAkOjJskpWfwiEiE\"}" }, { "empleeId": "03413862181677734352", "empleeName": "工程师d2", "serviceDeskId": 34636338, "remark": "{\"position\":\"\",\"remark\":\"\",\"department\":[34636338],\"unionid\":\"tCNXmMcRXajCLTvxNiS1T0QiEiE\",\"tel\":\"\",\"userid\":\"03413862181677734352\",\"isLeader\":false,\"avatar\":\"\",\"dingId\":\"$:LWCP_v1:$PNkq4XTwapIGxv+/cHCeSw\\u003d\\u003d\",\"workPlace\":\"\",\"jobnumber\":\"\",\"isBoss\":false,\"order\":\"92836695972687696\",\"email\":\"\",\"name\":\"工程师d2\",\"active\":false,\"isAdmin\":false,\"isHide\":false,\"mobile\":\"18116316326\",\"openId\":\"tCNXmMcRXajCLTvxNiS1T0QiEiE\"}" }] }] }];

    var host = window.location.hostname;
    if (host == "localhost") {
        self.vendorOrganization(fakeData);
        self.employees(self.vendorOrganization()[0].serviceDesks[0].empleeInfos);
    } else {
        $.getJSON(window.env.ddApiBaseUrl + "/itsm-ddtalk/api/vendor/depts_ddtalk", function(data) {
            if (data.status == "ok") {
                self.vendorOrganization(data.data);
                self.employees(self.vendorOrganization()[0].serviceDesks[0].empleeInfos);
            }
        });
    }

    self.toggleSubList = function(item, e) {
        var icon = $(e.target).parent().children('i:first');
        var subList = $(e.target).parent().next('ul');
        if (icon.hasClass("fa-angle-down")) {
            icon.removeClass("fa-angle-down").addClass("fa-angle-right");
            $(e.target).parent().next('ul').hide();
        } else {
            icon.removeClass("fa-angle-right").addClass("fa-angle-down");
            $(e.target).parent().next('ul').show();
        }

    };
    self.bindEmployees = function(subItem, e) {
        self.employees(subItem.empleeInfos);
        $('.sub-list *').removeClass("current");
        $(e.target).parent().addClass('current');
    }
};

ko.components.register("yum-vendor-organization", {
    template: `<div class="row">
            <div class="col-md-3 col-md-push-9">
            <ul class="list-unstyled" id="vendor-list" data-bind="foreach: vendorOrganization">
             <li class="vendor-group">
              <a href="#" data-bind="click: $component.toggleSubList"><i class="fa fa-angle-down pull-left"></i><i class="fa fa-building pull-left"></i><span data-bind="text: supProjectGroupName"></span></a>
             <ul class="sub-list list-unstyled" data-bind="foreach: serviceDesks">
              <li>
               <a href="#" data-bind="click: $component.bindEmployees"><i class="fa fa-wrench pull-left"></i><span data-bind="text: serviceDeskName"></span></a>
              </li>
             </ul>
             </li>
            </ul>
                   
            </div>
            <div class="col-md-9 col-md-pull-3">
                <section class="col-lg-12 connectedSortable">
                    <div class="box box-primary">
                    <div class="box-header">
                        
                    </div>
                    <div class="box-body">
                        <table id="employeeTable" class="table table-bordered table-hover">
                        <thead>
                            <tr>
                            <th>No.</th>
                            <th>姓名</th>
                            <th>手机</th>
                            </tr>
                        </thead>
                        <tbody data-bind="foreach: employees">
                            <tr>
                            <td data-bind="text: $index() + 1"></td>
                            <td data-bind="text: empleeName"></td>
                            <td data-bind="text: JSON.parse(remark).mobile"></td>
                            </tr>
                        </tbody>
                        </table>
                    </div>
                    </div>
                </section>
            </div>
        </div>`,
    viewModel: organizationViewModel
});