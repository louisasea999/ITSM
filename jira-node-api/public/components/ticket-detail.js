var utils = {
    getUrlParam: function(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    }
}

ko.components.register('yum-ticket-detail', {
    template: `
        <div class="row">
          <section class="col-lg-12 connectedSortable">
            <div class="box box-primary">
              <div class="box-header">
                <button type="button" class="btn btn-default pull-right" data-bind="click: back"> 返回</button>
              </div>
              <div class="box-body">
                <!-- ko with: issue -->
                <div class="form-group col-sm-12">
                  <label for="id" class="col-sm-2 control-label">ID</label>

                  <div class="col-sm-10">
                    <span data-bind="text: id"></span>
                  </div>
                </div>

                <div class="form-group col-sm-12">
                  <label for="key" class="col-sm-2 control-label">Key</label>

                  <div class="col-sm-10">
                    <span data-bind="text: key"></span>
                  </div>
                </div>
                 <div class="form-group col-sm-12">
                  <label for="key" class="col-sm-2 control-label">事件类型</label>

                  <div class="col-sm-10">
                    <span data-bind="text: issueType"></span>
                  </div>
                </div>
                <div class="form-group col-sm-12">
                  <label for="key" class="col-sm-2 control-label">创建人</label>

                  <div class="col-sm-10">
                    <span data-bind="text:creator.displayName"></span>
                    [<span data-bind="text:creator.emailAddress"></span>]
                  </div>
                </div>
                <div class="form-group col-sm-12">
                  <label for="key" class="col-sm-2 control-label">事件概要</label>

                  <div class="col-sm-10">
                    <span data-bind="text: summary"></span>
                  </div>
                </div>

                <div class="form-group col-sm-12">
                  <label for="key" class="col-sm-2 control-label">事件区域</label>

                  <div class="col-sm-10">
                    <span data-bind="text: area"></span>
                  </div>
                </div>

                <div class="form-group col-sm-12">
                  <label for="key" class="col-sm-2 control-label">餐厅门店编号</label>

                  <div class="col-sm-10">
                    <span data-bind="text: diningRoomNo"></span>
                  </div>
                </div>

                <div class="form-group col-sm-12">
                  <label for="key" class="col-sm-2 control-label">创建时间</label>

                  <div class="col-sm-10">
                    <span data-bind="text: createTime"></span>
                  </div>
                </div>

                <div class="form-group col-sm-12">
                  <label for="key" class="col-sm-2 control-label">事件描述</label>

                  <div class="col-sm-10">
                    <span data-bind="text: description"></span>
                  </div>
                </div>
                <!-- /ko -->
              </div>
              <div class="box-footer clearfix no-border">
                <button type="button" class="btn btn-default pull-right" data-bind="click: back"> 返回</button>
              </div>
            </div>
          </section>
        </div>
    `,
    viewModel: function() {
        var self = this;

        self.issue = ko.observable();

        self.issueId = utils.getUrlParam('issueId');

        $.get(window.env.baseUrl + "/v1/issue/sla/" + self.issueId, function(data) {
            //console.log(data);
            var issueObj = {
                id: data.issue.id,
                key: data.issue.key,
                issueType: data.issue.fields.issuetype.name,
                creator: data.issue.fields.creator,
                diningRoomNo: data.issue.fields.customfield_10007,
                area: data.issue.fields.customfield_10006,
                summary: data.issue.fields.summary,
                description: data.issue.fields.description
            }
            var date = new Date(data.issue.fields.created);
            issueObj.createTime = date.toLocaleDateString() + " " + date.toLocaleTimeString();
            self.issue(issueObj);
        });

        self.back = function() {
            window.history.go(-1);
        }
    }
});