ko.components.register('yum-container', {
    template: `
        <div class="content-wrapper">
        
        <yum-slash-path></yum-slash-path>
      
        <section class="content">

        <yum-create-issue></yum-create-issue>

        </section>
    </div>
    `,
    viewModel: function() {
        
    }
});