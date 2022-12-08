<p><CargoMessage type="WarehouseMovement-In"></p>
    <Header from="RAPIDCARGO" to="CARGOINFO" messageTime="2018-01-21T22:20:07.200Z" messageId="123456789" />
    <WarehouseMovementIn>
        <movementTime>coucou</movementTime>
        <declaredIn code="CDGRC1" label="RapidCargo CDG"/>
        <from code="CDGAF1" label="Air Cargo CDG 1"/>
        <goods>
            <ref type="${type}" code="07712345678"/>
            <amount quantity="${quantity}" weight="${weight}"/>
            <description>${description}</description>
            <totalRefAmount quantity="${totalQuantity}" weight="${totalWeight}"/>
        </goods>
    <customsStatus>X</customsStatus>
</WarehouseMovementIn>
</CargoMessage>
