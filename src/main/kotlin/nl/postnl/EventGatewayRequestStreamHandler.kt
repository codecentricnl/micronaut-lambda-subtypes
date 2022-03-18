package nl.postnl

import io.micronaut.context.env.Environment
import io.micronaut.core.annotation.Introspected
import io.micronaut.function.aws.MicronautRequestStreamHandler

@Introspected
class EventGatewayRequestStreamHandler : MicronautRequestStreamHandler() {
    override fun resolveFunctionName(env: Environment): String {
        return "EventGatewayManager"
    }
}
