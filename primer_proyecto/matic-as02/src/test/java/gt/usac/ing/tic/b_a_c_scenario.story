Narrative: Titular de la Cuenta paga un factura a partir banca
    Como titular de la cuenta
    Quiere pagar con su cuenta en la banca
    Con el fin de obtener dinero cuando el banco esta cerrado

Scenario: paga un factura a partir banca
Given pagar Servicios en Linea <p_usuario>
When selecciono la Cuenta asociada a mi usuario <p_cuenta>
When ingreso el numero de factura <p_no_factura>
When ingreso el monto a pagar <p_monto>
When presiono el boton de Transmitir
Then la factura existe
Then el monto no corresponde a la factura
Then la cuenta no tiene fondos para realizar el pago
Then se despliega el comprobante de pago

Examples:
|p_usuario|p_cuenta|p_no_factura|p_monto|
|lucita287@gmail.com|33230266888|FACT0003|900|
|lucita287@gmail.com|33130266522|FACT0091|600|
|yajomac@gmail.com|44330216528|FACT0002|700|
|yajomac@gmail.com|34130216527|FACT0004|1800|
|prisila.flores@gmail.com|31330819219|FACT0006|180|
|prisila.flores@gmail.com|44330815921|FACT0007|80|





