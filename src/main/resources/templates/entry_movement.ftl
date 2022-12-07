<?xml version="1.0">
<CargoMessage type="WarehouseMovement-In">
    <Header from="RAPIDCARGO" to="CARGOINFO" messageTime="2018-01-21T22:20:07.200Z" messageId="123456789" />
    <WarehouseMovementIn>
        <movementTime>${createdAt}</movementTime>
        <declaredIn code="CDGRC1" label="RapidCargo CDG"/>
        <from code="CDGAF1" label="Air Cargo CDG 1"/>
        <goods>
            <ref type="AWB" code="07712345678"/>
            <amount quantity="12" weight="345"/>
            <description>ELECTRONICS</description>
            <totalRefAmount quantity="${quantity}" weight="345"/>
        </goods>
    <customsStatus>X</customsStatus>
</WarehouseMovementIn>
</CargoMessage>