var utils = {
    getUrlParam: function(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); 
        var r = window.location.search.substr(1).match(reg); 
        if (r != null) return unescape(r[2]); return null;
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

        </section>
    </div>
    `,
    viewModel: function(params) {
        var self = this;

        var pageUrl = utils.getUrlParam('page');

        self.page = ko.observable(pageUrl === null ? "" : pageUrl);
    }
});