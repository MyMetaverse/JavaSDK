package io.mymetavese.metaapi.api.entities.drops.constraints;

public interface LimitedConsumptionDropConstraint extends DropConstraint {

    int getMaxConsumptionPerUser();

}
