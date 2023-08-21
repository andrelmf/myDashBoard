$(document).ready(function () {
    $('#myTable').DataTable( {
        
        // CollumnDefs:
        "columnDefs": [
            {
                "targets": [ 0 ], // coluna 0
                "width": "15%" // largura de 25%
            },
            {
                "targets": [ 1 ], // coluna 1
                "width": "15%" // largura de 50%
            },
            {
                "targets": [ 2 ], // coluna 2
                "width": "15%" // largura de 25%
            },
            {
                "targets": [ 3 ], // coluna 2
                "width": "20%" // largura de 25%
            },
            
        ],
        "language": {
            "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Portuguese.json"
        },
        "pageLength": 10,

        // Scroll - Vertical
        scrollY: 200,
        scrollX: true,
        scrollY: '50vh'
    }
    )
});
