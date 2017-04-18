var utils = {
    getUrlParam: function(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    }
}


ko.components.register('yum-container', {
    template: `
        <div class="content-wrapper">
        
        <yum-slash-path></yum-slash-path>
      
        <section class="content">
          <!-- ko if: page() === "" -->
          <yum-ticket-list></yum-ticket-list>
          <!-- /ko -->

          <!-- ko if: page() === "issueDetail" -->
          <yum-ticket-detail></yum-ticket-detail>
          <!-- /ko -->

          <!-- ko if: page() === "createIssue" -->
          <yum-create-issue></yum-create-issue>
          <!-- /ko -->

          <!-- ko if: page() === "taskList" -->
          <yum-task-list></yum-task-list>
          <!-- /ko -->

          <!-- ko if: page() === "vendorOrganization" -->
          <yum-vendor-organization></yum-vendor-organization>
          <!-- /ko -->

          <!-- ko if: page() === "ticket-list-area" -->
          <yum-area-list></yum-area-list>
          <!-- /ko -->

          <!-- ko if: page() === "ticket-list-diningRoom" -->
          <yum-diningroomdesks-list></yum-diningroomdesks-list>
          <!-- /ko -->

          <!-- ko if: page() === "ticket-list-diningRoomList" -->
          <yum-diningrooms-list></yum-diningrooms-list>
          <!-- /ko -->
        </section>
    </div>
    `,
    viewModel: function(params) {
        var self = this;

        var pageUrl = utils.getUrlParam('page');

        self.page = ko.observable(pageUrl === null ? "" : pageUrl);
    }
});