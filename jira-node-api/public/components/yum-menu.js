ko.components.register('yum-menu', {
    template: `
        <aside class="main-sidebar">
      <section class="sidebar">
        <form action="#" method="get" class="sidebar-form">
          <div class="input-group">
            <input type="text" name="q" class="form-control" placeholder="Search...">
            <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
          </div>
        </form>
        <ul class="sidebar-menu">
          <li class="header">MAIN NAVIGATION</li>          
          <!-- ko foreach: menus -->
          <li class="treeview" data-bind="css: {active: item.active}">
            <a href="#">
              <i class="fa fa-edit"></i> <span data-bind="text: item.title"></span>
              <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
            </a>
            <ul class="treeview-menu">
              <!-- ko foreach: item.subItems -->
              <li><a href="#" data-bind="attr: {href: link}"><i class="fa fa-circle-o"></i> <!-- ko text:title --><!-- /ko --></a></li>
              <!-- /ko -->
            </ul>
          </li>
          <!-- /ko -->
        </ul>
      </section>
    </aside>
    `,
    viewModel: function(params) {
        var self = this;
        self.roleMenus = [{
                role: "admin",
                menus: [{
                    item: {
                        title: "事件相关",
                        style: [],
                        active: true,
                        subItems: [
                            { title: "创建事件", link: "/pages/createIssue.html?page=createIssue&menu=0" },
                            { title: "已创建事件", link: "/index.html?menu=0" },
                            { title: "已结案", link: "/pages/completedIssue.html?page=completedIssue&menu=0" }
                        ]
                    }
                }, {
                    item: {
                        title: "配置列表",
                        style: [],
                        active: false,
                        subItems: [
                            { title: "餐厅列表", link: "/pages/ticket-list-diningRoomList.html?page=ticket-list-diningRoomList&menu=1" },
                            { title: "餐厅及服务站", link: "/pages/ticket-list-diningRoom.html?page=ticket-list-diningRoom&menu=1" },
                            { title: "区域及服务商", link: "/pages/ticket-list-area.html?page=ticket-list-area&menu=1" },
                            { title: "服务商组织结构", link: "/pages/vendorOrganization.html?page=vendorOrganization&menu=1" }
                        ]
                    }
                }]

            },
            {
                role: "storeuser",
                menus: [{
                    item: {
                        title: "事件相关",
                        style: [],
                        active: true,
                        subItems: [
                            { title: "创建事件", link: "/pages/createIssue.html?page=createIssue&menu=0" },
                            { title: "已创建事件", link: "/index.html&&menu=0" },
                            { title: "已结案", link: "/pages/completedIssue.html?page=completedIssue&menu=0" }
                        ]
                    }
                }]

            },
            {
                role: "nhdadmin",
                menus: [{
                    item: {
                        title: "配置列表",
                        style: [],
                        active: true,
                        subItems: [
                            { title: "区域及服务商", link: "/pages/ticket-list-area.html?page=ticket-list-area&menu=1" },
                            { title: "服务商组织结构", link: "/pages/vendorOrganization.html?page=vendorOrganization&menu=1" }
                        ]
                    }
                }]

            },
            {
                role: "regionit",
                menus: [{
                    item: {
                        title: "事件相关",
                        style: [],
                        active: true,
                        subItems: [
                            { title: "创建事件", link: "/pages/createIssue.html?page=createIssue&menu=0" },
                            { title: "已创建事件", link: "/index.html?menu=0" },
                            { title: "已结案", link: "/pages/completedIssue.html?page=completedIssue&menu=0" }
                        ]
                    }
                }, {
                    item: {
                        title: "配置列表",
                        style: [],
                        active: false,
                        subItems: [
                            { title: "餐厅列表", link: "/pages/ticket-list-diningRoomList.html?page=ticket-list-diningRoomList&menu=1" },
                            { title: "餐厅及服务站", link: "/pages/ticket-list-diningRoom.html?page=ticket-list-diningRoom&menu=1" }
                        ]
                    }
                }]

            },
            {
                role: "regionaait",
                menus: [{
                    item: {
                        title: "事件相关",
                        style: [],
                        active: true,
                        subItems: [
                            { title: "创建事件", link: "/pages/createIssue.html?page=createIssue&menu=0" },
                            { title: "已创建事件", link: "/index.html?menu=0" },
                            { title: "已结案", link: "/pages/completedIssue.html?page=completedIssue&menu=0" }
                        ]
                    }
                }, {
                    item: {
                        title: "配置列表",
                        style: [],
                        active: true,
                        subItems: [
                            { title: "餐厅列表", link: "/pages/ticket-list-diningRoomList.html?page=ticket-list-diningRoomList&menu=1" },
                            { title: "餐厅及服务站", link: "/pages/ticket-list-diningRoom.html?page=ticket-list-diningRoom&menu=1" }
                        ]
                    }
                }]

            }
        ];

        var role = window.sessionStorage["account"];
        $.each(self.roleMenus, function(index) {
            if (self.roleMenus[index].role.toLowerCase() == role.toLowerCase()) {
                self.menus = self.roleMenus[index].menus;
                var currentActiveMenuIndex = parseInt(utils.getUrlParam('menu'));
                // console.log(currentActiveMenuIndex);
                if (currentActiveMenuIndex != NaN && currentActiveMenuIndex < self.menus.length) {
                    $.each(self.menus, function(i) {
                        if (i == currentActiveMenuIndex) {
                            self.menus[i].item.active = true;
                        } else {
                            self.menus[i].item.active = false;
                        }
                    });
                }
                return false;
            }
        });
        //console.log(self.menus);
    }
});