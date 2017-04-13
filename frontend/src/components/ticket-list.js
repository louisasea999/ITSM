
function createViewModel() {
    this.issues = [
        {
            "key": "YUM-2",
            "keyHtml": "YUM-2",
            "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
            "summary": "Test issue 2",
            "summaryText": "Test issue 2"
        }, {
            "key": "YUM-1",
            "keyHtml": "YUM-1",
            "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
            "summary": "Test issue retrieve",
            "summaryText": "Test issue retrieve"
        }, {
            "key": "YUM-1",
            "keyHtml": "YUM-1",
            "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
            "summary": "Test issue retrieve",
            "summaryText": "Test issue retrieve"
        }, {
            "key": "YUM-1",
            "keyHtml": "YUM-1",
            "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
            "summary": "Test issue retrieve",
            "summaryText": "Test issue retrieve"
        }, {
            "key": "YUM-1",
            "keyHtml": "YUM-1",
            "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
            "summary": "Test issue retrieve",
            "summaryText": "Test issue retrieve"
        }, {
            "key": "YUM-1",
            "keyHtml": "YUM-1",
            "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
            "summary": "Test issue retrieve",
            "summaryText": "Test issue retrieve"
        }, {
            "key": "YUM-1",
            "keyHtml": "YUM-1",
            "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
            "summary": "Test issue retrieve",
            "summaryText": "Test issue retrieve"
        }, {
            "key": "YUM-1",
            "keyHtml": "YUM-1",
            "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
            "summary": "Test issue retrieve",
            "summaryText": "Test issue retrieve"
        }, {
            "key": "YUM-9",
            "keyHtml": "YUM-1",
            "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
            "summary": "Test issue retrieve",
            "summaryText": "Test issue retrieve"
        }, {
            "key": "YUM-10",
            "keyHtml": "YUM-1",
            "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
            "summary": "Test issue retrieve",
            "summaryText": "Test issue retrieve"
        }, {
            "key": "YUM-11",
            "keyHtml": "YUM-1",
            "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
            "summary": "Test issue retrieve",
            "summaryText": "Test issue retrieve"
        }
    ];
}

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
                        <a href="./issueDetail.html"><i class="fa fa-edit"></i></a>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <div class="box-footer clearfix no-border">
                <button type="button" class="btn btn-default pull-right"><i class="fa fa-plus"></i> 创建事件</button>
              </div>
            </div>
          </section>
        </div>
    `,
    viewModel: createViewModel
});

