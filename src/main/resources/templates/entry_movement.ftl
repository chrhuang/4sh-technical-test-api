<p><CargoMessage type="WarehouseMovement-In"></p>
    <Header from="RAPIDCARGO" to="CARGOINFO" messageTime="${currentTime}" messageId="${id}" />
    <WarehouseMovementIn>
        <movementTime>${createdAt}</movementTime>
        <declaredIn code="CDGRC1" label="RapidCargo CDG"/>
        <from code="CDGAF1" label="Air Cargo CDG 1"/>
        <goods>
            <ref type="${type}" code="${reference}"/>
            <amount quantity="${quantity}" weight="${weight}"/>
            <description>${description}</description>
            <totalRefAmount quantity="${totalQuantity}" weight="${totalWeight}"/>
        </goods>
    <customsStatus>${customsCode}</customsStatus>
</WarehouseMovementIn>
</CargoMessage>
