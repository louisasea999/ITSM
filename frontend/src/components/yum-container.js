ko.components.register('yum-container', {
    template: `
        <div class="content-wrapper">
        
        <yum-slash-path></yum-slash-path>
      
        <section class="content">

          <yum-ticket-list></yum-ticket-list>

        </section>
    </div>
    `,
    viewModel: function() {
        
    }
});