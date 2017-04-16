ko.components.register('yum-ticket-list', {
    template: `
        <div class="row">
          <section class="col-lg-12 connectedSortable">
              <div class="box box-primary">
                  <div class="box-header">

                  </div>
                  <div class="box-body">
                      <table id="issueTable" class="table table-bordered table-hover">
                          <thead>
                              <tr>
                                  <th>No.</th>
                                  <th>Key</th>
                                  <th>Summary</th>
                                  <th>Summary Text</th>
                                  <th>View/Edit</th>
                              </tr>
                          </thead>
                          <tbody data-bind="foreach: issues">
                              <tr>
                                  <td data-bind="text: $index() + 1"></td>
                                  <td data-bind="text: key"></td>
                                  <td data-bind="text: summary"></td>
                                  <td data-bind="text: summaryText"></td>
                                  <td>
                                      <a data-bind="attr:{href: '/pages/issueDetail.html?page=issueDetail&issueId=' + key}"><i class="fa fa-edit"></i></a>
                                  </td>
                              </tr>
                          </tbody>
                      </table>
                  </div>
                  <div class="box-footer clearfix no-border">
                      <a class="btn btn-default pull-right" href="/pages/createIssue.html?page=createIssue"><i class="fa fa-plus"></i> 创建事件</a>
                  </div>
              </div>
          </section>
      </div>
    `,
    viewModel: function() {
        var self = this;

        self.issues = ko.observableArray([]);

        $.get(window.env.baseUrl + "/v1/issues", function(data) {
            self.issues(data.sections[0].issues);
        });
    }
});

