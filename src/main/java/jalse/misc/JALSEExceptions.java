package jalse.misc;

import jalse.JALSE;
import jalse.actions.ActionEngine;
import jalse.attributes.AttributeType;
import jalse.entities.Entity;
import jalse.entities.EntityContainer;
import jalse.entities.EntityProxies;

import java.util.function.Supplier;

/**
 * These are the suppliers for all the common specific exceptions JALSE throws. JALSE currently does
 * not provide any custom exception types but instead uses the suitable {@code java.lang}
 * exceptions.
 *
 * @author Elliot Ford
 *
 */
public final class JALSEExceptions {

    /**
     * Runtime exception supplier for when an entity is associated twice.
     *
     * @see EntityContainer
     */
    public static final Supplier<RuntimeException> ENTITY_ALREADY_ASSOCIATED = () -> new IllegalArgumentException(
	    "Entity is already associated");

    /**
     * Runtime exception supplier for attempting to change the running state of a stopped engine.
     *
     * @see ActionEngine
     */
    public static final Supplier<RuntimeException> ENGINE_SHUTDOWN = () -> new IllegalStateException(
	    "Engine has already been stopped");

    /**
     * Runtime exception supplier for when a entity is created past the total entity limit set.
     *
     * @see JALSE
     */
    public static final Supplier<RuntimeException> ENTITY_LIMIT_REACHED = () -> new IllegalStateException(
	    "Entity limit has been reached");

    /**
     * Runtime exception supplier for when an {@code interface} without {@link Entity} as a parent
     * is being used as an entity type.
     *
     * @see EntityProxies
     */
    public static final Supplier<RuntimeException> INVALID_ENTITY_TYPE = () -> new IllegalArgumentException(
	    "Entity type is invalid");

    /**
     * Runtime exception supplier for creation operations are done against an entity that is no
     * longer alive.
     *
     * @see Entity
     */
    public static final Supplier<RuntimeException> ENTITY_NOT_ALIVE = () -> new IllegalStateException(
	    "Entity is no longer alive");

    /**
     * An Entity has been exported from one container but was not able to be transfered to the
     * destination container.
     *
     * @see EntityContainer
     */
    public static final Supplier<RuntimeException> ENTITY_EXPORT_NO_TRANSFER = () -> new IllegalStateException(
	    "Entity exported but not transfered");

    /**
     * An Entity is being transfered to the same container it is already is.
     *
     * @see EntityContainer
     */
    public static final Supplier<RuntimeException> CANNOT_SELF_TRANSFER = () -> new IllegalArgumentException(
	    "Cannot transfer to the same container");

    /**
     * An AttributeType should be initilised correctly.
     *
     * @see AttributeType
     */
    public static final Supplier<RuntimeException> INVALID_ATTRTYPE_SUBTYPE = () -> new IllegalStateException(
	    "AttributeType must be initialised in a way that provides generic type information: new AttributeType<String>{}");

    /**
     * Throws the runtime exception generated by the supplier.
     *
     * @param supplier
     *            Runtime exception supplier.
     * @throws RuntimeException
     *             Will throw the supplied exception or will null pointer if supplied with
     *             {@code null}.
     */
    public static void throwRE(final Supplier<? extends RuntimeException> supplier) throws RuntimeException {
	throw supplier.get();
    }

    private JALSEExceptions() {
	throw new UnsupportedOperationException();
    }
}
