package jalse.entities.annotations;

import jalse.attributes.Attribute;
import jalse.attributes.AttributeContainer;
import jalse.entities.Entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Optional;

/**
 * An {@link Entity} type annotation for {@link AttributeContainer#addAttributeOfType(Attribute)},
 * {@link AttributeContainer#addOrNullAttributeOfType(Attribute)},
 * {@link AttributeContainer#removeAttributeOfType(Class)} and
 * {@link AttributeContainer#removeOrNullAttributeOfType(Class)}.<br>
 * <br>
 * The correct method is selected depending if the result is wrapped in an {@link Optional} and if
 * the argument supplied to the proxy is {@code null} (removal).
 *
 * @author Elliot Ford
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SetAttribute {}
