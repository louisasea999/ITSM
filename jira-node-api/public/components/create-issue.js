ko.components.register('yum-create-issue', {
    template: `
        <div class="row">
          <section class="col-lg-12 connectedSortable">
            <div class="box box-primary">
              <div class="box-header">
                创建事件
                <button type="button" class="btn btn-default pull-right" data-bind="click: back"> 返回</button>
              </div>
              <div class="box-body">
                <!-- ko with: issue.fields -->
                <div class="form-group col-sm-12">
                  <label for="key" class="col-sm-2 control-label">所属工程ID</label>

                  <div class="col-sm-6">
                    <span data-bind="text:project.id"></span>
                  </div>
                </div>
                 <div class="form-group col-sm-12">
                  <label for="key" class="col-sm-2 control-label">事件类型</label>

                  <div class="col-sm-6">
                    <select class="form-control" disabled data-bind="value: issuetype.id">
                        <option value="10002">餐厅门店报修事件</option>
                    </select>
                  </div>
                </div>

                <div class="form-group col-sm-12">
                  <label for="key" class="col-sm-2 control-label">餐厅门店编号</label>

                  <div class="col-sm-6">
                    <input type="text" class="form-control" data-bind="value: customfield_10002" />
                  </div>
                </div>

                <div class="form-group col-sm-12">
                  <label for="key" class="col-sm-2 control-label">餐厅区域</label>

                  <div class="col-sm-6">
                    <input type="text" class="form-control" data-bind="value: customfield_10003" />
                  </div>
                </div>       

                <div class="form-group col-sm-12">
                  <label for="key" class="col-sm-2 control-label">汇总</label>

                  <div class="col-sm-6">
                    <input type="text" class="form-control" data-bind="value: summary" />
                  </div>
                </div>     

                 <div class="form-group col-sm-12">
                  <label for="key" class="col-sm-2 control-label">优先级</label>

                  <div class="col-sm-6">
                    <select class="form-control" data-bind="value: priority.id">
                        <option value="1">P0</option>
                        <option value="2">P1</option>
                        <option value="3">P2</option>
                        <option value="4">P3</option>
                    </select>
                  </div>
                  <div class="2">
                    <img data-bind="attr: {src: $component.priorities[parseInt(priority.id(), 10) - 1].iconUrl} " height="15" alt="" />
                  </div>
                </div>    

                <div class="form-group col-sm-12">
                  <label for="key" class="col-sm-2 control-label">事件描述</label>

                  <div class="col-sm-6">
                    <textarea rows="3" class="form-control" data-bind="value: description"></textarea>
                  </div>
                </div>
                <!-- /ko -->

              </div>
              <div class="box-footer clearfix no-border">
                <div class="col-sm-8">
                    <button type="button" class="btn btn-primary pull-right" data-bind="click: create, text: $component.sbmitBtnTxt"></button>
                </div>
              </div>
            </div>
          </section>
        </div>
    `,
    viewModel: function() {
        var self = this;

        self.sbmitBtnTxt = ko.observable(' 确认');

        self.priorities = [
          {
            "self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/priority/1",
            "statusColor": "#d04437",
            "description": "This problem will block progress.",
            "iconUrl": "http://itsmpoc6341.cloudapp.net:90/images/icons/priorities/highest.svg",
            "name": "P0",
            "id": "1"
          },
          {
            "self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/priority/2",
            "statusColor": "#f15C75",
            "description": "Serious problem that could block progress.",
            "iconUrl": "http://itsmpoc6341.cloudapp.net:90/images/icons/priorities/high.svg",
            "name": "P1",
            "id": "2"
          },
          {
            "self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/priority/3",
            "statusColor": "#f79232",
            "description": "Has the potential to affect progress.",
            "iconUrl": "http://itsmpoc6341.cloudapp.net:90/images/icons/priorities/medium.svg",
            "name": "P2",
            "id": "3"
          },
          {
            "self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/priority/4",
            "statusColor": "#707070",
            "description": "Minor problem or easily worked around.",
            "iconUrl": "http://itsmpoc6341.cloudapp.net:90/images/icons/priorities/low.svg",
            "name": "P3",
            "id": "4"
          }
        ];

        self.issueTypes = [
          {
            "self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/issuetype/10000",
            "id": "10000",
            "description": "需要完成的任务。",
            "iconUrl": "http://itsmpoc6341.cloudapp.net:90/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
            "name": "任务",
            "subtask": false,
            "avatarId": 10318
          },
          {
            "self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/issuetype/10001",
            "id": "10001",
            "description": "问题的子任务",
            "iconUrl": "http://itsmpoc6341.cloudapp.net:90/secure/viewavatar?size=xsmall&avatarId=10316&avatarType=issuetype",
            "name": "子任务",
            "subtask": true,
            "avatarId": 10316
          },
          {
            "self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/issuetype/10002",
            "id": "10002",
            "description": "餐厅门店报修事件",
            "iconUrl": "http://itsmpoc6341.cloudapp.net:90/secure/viewavatar?size=xsmall&avatarId=10300&avatarType=issuetype",
            "name": "StoreSupportCase",
            "subtask": false,
            "avatarId": 10300
          },
          {
            "self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/issuetype/10003",
            "id": "10003",
            "description": "服务商工单",
            "iconUrl": "http://itsmpoc6341.cloudapp.net:90/secure/viewavatar?size=xsmall&avatarId=10316&avatarType=issuetype",
            "name": "VendorSupportCase",
            "subtask": true,
            "avatarId": 10316
          }
        ];

        self.issue = {
            "fields": {
              "project": {
                "id": "10001"
              },
              "summary": ko.observable(''),
              "issuetype": {
                "id": ko.observable('')
              },
              "priority": {
                "id": ko.observable(1)
              },
              "customfield_10002": ko.observable(''),
              "customfield_10003": ko.observable(''),
              "description": ko.observable('')
          }             
        };

        self.create = function() {
            var temp = ko.toJS(self.issue);
            var choosenPriority = self.priorities[parseInt(temp.fields.priority.id, 10) - 1];

            temp.fields.priority = choosenPriority;
            self.sbmitBtnTxt('提交中...');

            $.ajax({
                type: "POST",
                url: window.env.baseUrl + "/v1/issue",
                data: JSON.stringify(temp),
                timeout: 30000,
                headers: {
                    "Content-Type":"application/json; charset=utf-8"
                },
                success: function(data) {
                    if(typeof data === "object" && data.hasOwnProperty('key')) {
                        alert('创建成功');
                        window.location.href = '/index.html'
                    } else {
                        alert('创建失败');
                        self.sbmitBtnTxt(' 确认');
                    }
                },
                error: function(request, status, err) {
                    self.sbmitBtnTxt(' 确认');
                    if(status == "timeout") {
                        alert('Error: Timeout');
                    } else {
                        alert('Error');
                    }
                }
            });
        }

        self.back = function() {
          window.history.go(-1);
        }
    }
});

