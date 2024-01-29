var customerDB = [
    {id: "C00-001", name: "Pasindu Madhawa", address: "Galle Baddegama", contact: "071-2345678"},
    {id: "C00-002", name: "Dasun Shanaka", address: "Colombo 07", contact: "071-9876541"}
];

var itemDB = [
    {code:"I00-001",name:"Pen-Brand 1",unitPrice: 20.00,qty: 500},
    {code:"I00-002",name:"Eraser",unitPrice: 40.00,qty: 50}
];

var orderDB = [
    {oid:"OID-001", orderDate:"2023/10/06", custID:"C00-001", discount: 5, finalPrice: 2033,
        orderDetails:[
            {itmCode:"I00-001", unitPrice:145.00, qty:10},
            {itmCode:"I00-002", unitPrice:345.00, qty:2}
        ]
    }
];