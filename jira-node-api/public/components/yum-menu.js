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
    viewModel: function (params) {
      this.menus = [
        {
          item: {
            title: '订单相关',
            style: [],
            active: true,
            subItems: [
              {
                title: '创建事件',
                link: '/pages/createIssue.html?page=createIssue',
              },
              {
                title: '已创建事件',
                link: '/index.html',
              },
              {
                title: '已结案',
                link: '/pages/completedIssue.html?page=completedIssue',
              }
            ]
          }
        },
        {
          item: {
            title: '列表',
            style: [],
            active: false,
            subItems: [
              {
                title: '服务商',
                link: '#?page=vendors',
              },
              {
                title: '区域及门店',
                link: '#?page=area',
              },
              {
                title: '服务商组织结构',
                link: '/pages/vendorOrganization.html?page=vendorOrganization'
              }
            ]
          }
        },
        
      ]
    }
});