package io.mymetavese.metaapi.api.entities.Metadata;

public interface TokenAchievement {

    /**
     * Return the name for this achievement.
     * @return A string with the name for this token.
     */
    String getName();

    /**
     * Return an object with the value of this token.
     * <br />
     * <b>Note:</b> First check the instance of this object to be secure.
     * @return An object that can be either String or Integer with the value of this achievement.
     */
    Object getValue();

}
