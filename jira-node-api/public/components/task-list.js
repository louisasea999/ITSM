ko.components.register('yum-task-list', {
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
                                  <th>Priority</th>
                                  <th>Status</th>                               
                              </tr>
                          </thead>
                          <tbody data-bind="foreach: tasks">
                              <tr>
                                  <td data-bind="text: $index() + 1"></td>
                                  <td data-bind="text: key"></td>
                                  <td data-bind="text: summary"></td>
                                  <td data-bind="text: priority"></td>
                                  <td data-bind="text: status"></td>
                              </tr>
                          </tbody>
                      </table>
                  </div>
              </div>
          </section>
      </div>
    `,
    viewModel: function() {
        var self = this;

        self.tasks = ko.observableArray([]);

        $.get(window.env.baseUrl + "/v1/issues", function(data) {
            //console.log(data);
            var taskList = [];
            $.each(data.issues, function(i, d) {
                if (d.fields.subtasks != null && d.fields.subtasks.length > 0) {
                    //console.log(d.fields.subtasks);
                    $.each(d.fields.subtasks, function(j, subtask) {
                        if (subtask.fields.issuetype.name == "VendorSupportCase") {
                            taskList.push({
                                parentKey: d.key,
                                key: subtask.key,
                                summary: subtask.fields.summary,
                                priority: subtask.fields.priority.name,
                                status: subtask.fields.status.name
                            });
                        }
                    });
                }
            });
            //console.log(taskList);
            self.tasks(taskList);
        });
    }
});