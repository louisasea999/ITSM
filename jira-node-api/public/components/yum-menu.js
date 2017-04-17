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
                            { title: "创建事件", link: "/pages/createIssue.html?page=createIssue" },
                            { title: "已创建事件", link: "/index.html" },
                            { title: "已结案", link: "/pages/completedIssue.html?page=completedIssue" }
                        ]
                    }
                }, {
                    item: {
                        title: "列表",
                        style: [],
                        active: false,
                        subItems: [
                            { title: "餐厅列表", link: "/pages/ticket-list-diningRoomList.html?page=ticket-list-diningRoomList" },
                            { title: "餐厅及服务站", link: "/pages/ticket-list-diningRoom.html?page=ticket-list-diningRoom" },
                            { title: "区域及服务商", link: "/pages/ticket-list-area.html?page=ticket-list-area" },
                            { title: "服务商组织结构", link: "/pages/vendorOrganization.html?page=vendorOrganization" }
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
                            { title: "创建事件", link: "/pages/createIssue.html?page=createIssue" },
                            { title: "已创建事件", link: "/index.html" },
                            { title: "已结案", link: "/pages/completedIssue.html?page=completedIssue" }
                        ]
                    }
                }]

            },
            {
                role: "nhdadmin",
                menus: [{
                    item: {
                        title: "列表",
                        style: [],
                        active: true,
                        subItems: [
                            { title: "区域及服务商", link: "/pages/ticket-list-area.html?page=ticket-list-area" },
                            { title: "服务商组织结构", link: "/pages/vendorOrganization.html?page=vendorOrganization" }
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
                            { title: "创建事件", link: "/pages/createIssue.html?page=createIssue" },
                            { title: "已创建事件", link: "/index.html" },
                            { title: "已结案", link: "/pages/completedIssue.html?page=completedIssue" }
                        ]
                    }
                }, {
                    item: {
                        title: "列表",
                        style: [],
                        active: false,
                        subItems: [
                            { title: "餐厅列表", link: "/pages/ticket-list-diningRoomList.html?page=ticket-list-diningRoomList" },
                            { title: "餐厅及服务站", link: "/pages/ticket-list-diningRoom.html?page=ticket-list-diningRoom" }
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
                            { title: "创建事件", link: "/pages/createIssue.html?page=createIssue" },
                            { title: "已创建事件", link: "/index.html" },
                            { title: "已结案", link: "/pages/completedIssue.html?page=completedIssue" }
                        ]
                    }
                }, {
                    item: {
                        title: "列表",
                        style: [],
                        active: true,
                        subItems: [
                            { title: "餐厅列表", link: "/pages/ticket-list-diningRoomList.html?page=ticket-list-diningRoomList" },
                            { title: "餐厅及服务站", link: "/pages/ticket-list-diningRoom.html?page=ticket-list-diningRoom" }
                        ]
                    }
                }]

            }
        ];

        var role = window.sessionStorage["account"];
        $.each(self.roleMenus, function(index) {
            if (self.roleMenus[index].role.toLowerCase() == role.toLowerCase()) {
                self.menus = self.roleMenus[index].menus;
                return false;
            }
        });
    }
});