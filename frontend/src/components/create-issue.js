function issueViewModel(){
    this.districts = [
        "District A", "District B", "District C", "District D"
    ];
    this.incidentTypes = [
        "Incident Type1", "Incident Type2", "Incident Type3"
    ];
}

ko.components.register('yum-create-issue', {
    template:
        `
                <div class="row">
                    <!-- Left col -->
                    <section class="col-lg-12 connectedSortable">
                        <!-- TO DO List -->
                        <div class="box box-primary">
                            <div class="box-header">

                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">

                                <div class="form-group col-md-6">
                                    <label>Restaurant District: </label>
                                    <div class="input-group">
                                    <select data-bind="options: districts" class="form-control select2">
                                    </select>
                                    </div>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Restaurant NO.: </label>

                                    <div class="input-group">
                                        <input type="text" class="form-control" data-mask>
                                    </div>
                                    <!-- /.input group -->
                                </div>

                                <div class="form-group col-md-6">
                                    <label>Creator: </label>

                                    <div class="input-group">
                                        <input type="text" class="form-control" data-mask>
                                    </div>
                                    <!-- /.input group -->
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Incident Type: </label>
                                    <div class="input-group">
                                    <select data-bind="options: incidentTypes" class="form-control select2" >
                                    </select>
                                    </div>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Incident Summary: </label>
                                        <div class="input-group">
                                        <textarea style="width:60%;" class="form-control" data-mask>
                                        </textarea>
                                        </div>
                                    <!-- /.input group -->
                                </div>                             

                                <div class="form-group col-md-6">
                                    <label>Incident Description: </label>
                                    <div class="input-group">
                                        <textarea style="width:60%;height:100px;" class="form-control" data-mask>
                                        </textarea>
                                        </div>
                                    <!-- /.input group -->
                                </div>   

                                <div class="form-group col-md-6">
                                    <label>Responsible District: </label>
                                    <div class="input-group">
                                    <select data-bind="options: districts" class="form-control select2">
                                    </select>
                                    </div>
                                    <!-- /.input group -->
                                </div> 
                                <div class="form-group col-md-6">
                                <label></label>
                                    <div class="input-group">
                                     <button type="button" id="btn-submit-incident" class="btn btn-default">Submit</button>
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->
                        </div>
                        <!-- /.box -->
                    </section>
                    <!-- /.Left col -->
                </div>
        `
    ,
    viewModel: issueViewModel
})