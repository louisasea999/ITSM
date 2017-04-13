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
          <li class="active treeview">
            <a href="#">
              <i class="fa fa-dashboard"></i> <span>工单</span>
              <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
            </a>
            <ul class="treeview-menu">
              <li class="active"><a href="#"><i class="fa fa-circle-o"></i> 未处理</a></li>
              <li><a href="#"><i class="fa fa-circle-o"></i>已接单</a></li>
              <li><a href="#"><i class="fa fa-circle-o"></i>正在处理</a></li>
              <li><a href="#"><i class="fa fa-circle-o"></i>已结案</a></li>
            </ul>
          </li>
          <li class="treeview">
            <a href="#">
              <i class="fa fa-edit"></i> <span>配置关联</span>
              <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
            </a>
            <ul class="treeview-menu">
              <li><a href="#"><i class="fa fa-circle-o"></i> 区域与服务商</a></li>
              <li><a href="#"><i class="fa fa-circle-o"></i> 区域与服务站</a></li>
            </ul>
          </li>
        </ul>
      </section>
    </aside>
    `,
    viewModel: function () {

    }
});