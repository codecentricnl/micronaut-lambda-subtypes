package nl.postnl

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import io.micronaut.core.annotation.Introspected
import io.micronaut.function.FunctionBean
import java.util.function.Function

@Introspected
@FunctionBean("EventGatewayManager")
class EventGatewayManager(): Function<Command, Response> {
    override fun apply(t: Command): Response {
        return Response(t is PutSubscriptionCommand)
    }
}

@Introspected(accessKind = [Introspected.AccessKind.FIELD])
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(
    JsonSubTypes.Type(value = PutSubscriptionCommand::class, name = "putSubscriptionCommand"),
)
abstract class Command

data class PutSubscriptionCommand(val subscriptionId: String): Command()

data class Response(val success: Boolean)