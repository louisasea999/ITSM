if (window.sessionStorage.getItem("account") == null || window.sessionStorage.getItem("account") == undefined) {
    window.location.href = "/login.html";
}

ko.components.register('yum-header', {
    viewModel: function(params) {
        this.userName = window.sessionStorage.getItem("account");
        this.signOut = function() {
            window.sessionStorage.removeItem("account");
            window.sessionStorage.removeItem("role");
            window.sessionStorage.removeItem("region");
            window.sessionStorage.removeItem("vendor");
            window.location.href = "/login.html";
        }
    },
    template: `<header class="main-header">
      <a href="#" class="logo">
        <span class="logo-lg"><b>ITSM</b>&nbsp;Portal</span>
      </a>
      <nav class="navbar navbar-static-top">
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
          <span class="sr-only">Toggle navigation</span>
        </a>

        <div class="navbar-custom-menu">
          <ul class="nav navbar-nav">

            <li class="dropdown notifications-menu">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <i class="fa fa-bell-o"></i>
                <span class="label label-warning">1</span>
              </a>
              <ul class="dropdown-menu">
                <li class="header">You have 1 notifications</li>
                <li>
                  <ul class="menu">
                    <li>
                      <a href="#">
                        <i class="fa fa-users text-aqua"></i> 5 new members joined today
                      </a>
                    </li>
                  </ul>
                </li>
                <li class="footer"><a href="#">View all</a></li>
              </ul>
            </li>
            <li class="dropdown user user-menu">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <img src="../../dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                <span class="hidden-xs" data-bind="text: userName"></span>
              </a>
              <!--
              <ul class="dropdown-menu">
                <li class="user-header">
                  <img src="../../dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                  <p>
                    Administrator - Web Developer
                    <small>Member since Nov. 2012</small>
                  </p>
                </li>
                <li class="user-body">
                  <div class="row">
                    <div class="col-xs-4 text-center">
                      <a href="#">Followers</a>
                    </div>
                    <div class="col-xs-4 text-center">
                      <a href="#">Sales</a>
                    </div>
                    <div class="col-xs-4 text-center">
                      <a href="#">Friends</a>
                    </div>
                  </div>
                </li>
                <li class="user-footer">
                  <div class="pull-left">
                    <a href="#" class="btn btn-default btn-flat">Profile</a>
                  </div>
                  <div class="pull-right">
                    <a href="/login.html" class="btn btn-default btn-flat">Sign out</a>
                  </div>
                </li>
              </ul>
              -->
             
            </li>
            <li>
              <a href="#" data-bind="click: signOut" titile="Sing out" class="fa fa-sign-out"></a>
            </li>
          </ul>
         
        </div>
      </nav>
    </header>`
});