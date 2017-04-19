var utils = {
    getUrlParam: function(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    }
}

ko.components.register('yum-task-detail', {
    template: `
        <div class="row">
          <section class="col-lg-12 connectedSortable">
            <div class="box box-primary">
              <div class="box-header">
                <button type="button" class="btn btn-default pull-right" data-bind="click: back"> 返回</button>
              </div>
              <div class="box-body">
                <!-- ko with: task -->
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
                 <label for="key" class="col-sm-2 control-label">工单概要</label>
                  <div class="col-sm-10">
                    <span data-bind="text: summary"></span>
                  </div>
                </div>

                  <div class="form-group col-sm-12">
                   <label for="key" class="col-sm-2 control-label">SLA</label>
                <div class="col-sm-10">
                    <span data-bind="text: SLA"></span>
                  </div>
                </div>

                   <div class="form-group col-sm-12">
                  <label for="key" class="col-sm-2 control-label">优先级</label>
                  <div class="col-sm-10">
                    <span data-bind="text: priority"></span>
                  </div>
                </div>   

                <div class="form-group col-sm-12">
                  <label for="key" class="col-sm-2 control-label">状态</label>
                  <div class="col-sm-10">
                    <span data-bind="text: status"></span>
                  </div>
                </div> 

                <div class="form-group col-sm-12">
                  <label for="key" class="col-sm-2 control-label">服务商</label>
                  <div class="col-sm-10">
                    <span data-bind="text: vendor"></span>
                  </div>
                </div>

                <div class="form-group col-sm-12">
                  <label for="key" class="col-sm-2 control-label">工单区域</label>
                  <div class="col-sm-10">
                    <span data-bind="text: area"></span>
                  </div>
                </div>

                <div class="form-group col-sm-12">
                  <label for="key" class="col-sm-2 control-label">工单门店编号</label>
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
                  <label for="key" class="col-sm-2 control-label">创建人</label>
                  <div class="col-sm-10">
                    <span data-bind="text:creator.displayName"></span>
                    [<span data-bind="text:creator.emailAddress"></span>]
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

        self.task = ko.observable();

        self.issueId = utils.getUrlParam('taskId');

        $.get(window.env.baseUrl + "/v1/issue/sla/" + self.issueId, function(data) {
            //console.log(data);
            var taskObj = {
                id: data.issue.id,
                key: data.issue.key,
                SLA: data.sla,
                //issueType: data.issue.fields.issuetype.name,
                priority: data.issue.fields.priority.name,
                status: data.issue.fields.status.name,
                diningRoomNo: data.issue.fields.customfield_10007,
                area: data.issue.fields.customfield_10006,
                vendor: data.issue.fields.customfield_10017 != null ? data.issue.fields.customfield_10017.value : "",
                summary: data.issue.fields.summary,
                //description: data.issue.fields.description,
                creator: data.issue.fields.creator
            }
            var date = new Date(data.issue.fields.created);
            taskObj.createTime = date.toLocaleDateString() + " " + date.toLocaleTimeString();
            if (data.sla != null) {
                taskObj.SLA = data.sla + " 小时"
            } else {
                taskObj.SLA = 0;
            }
            //console.log(taskObj);
            self.task(taskObj);
        });

        self.back = function() {
            window.history.go(-1);
        }
    }
});