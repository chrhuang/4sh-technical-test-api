<CargoMessage type="WarehouseMovement-Out">
    <Header from="RAPIDCARGO" to="CARGOINFO" messageTime="${currentTime}" messageId="${id}" />
    <WarehouseMovementOut>
        <movementTime>${createdAt}</movementTime>
        <declaredIn code="CDGRC1" label="RapidCargo CDG"/>
        <to code="CDGAF1" label="Air Cargo CDG 1"/>
        <goods>
            <ref type="${type}" code="${reference}"/>
            <amount quantity="${quantity}" weight="${weight}"/>
            <description>${description}</description>
            <totalRefAmount quantity="${totalQuantity}" weight="${totalWeight}"/>
        </goods>
        <customsStatus>${customsCode}</customsStatus>
        <customsDocument type="${customsDocumentType}" ref="${customsDocumentReference}" />
    </WarehouseMovementOut>
</CargoMessage>