package com.bsp.oauth2.authorization.server.jackson2.deserializer;

import com.bsp.oauth2.authorization.server.entity.UserAuthority;
import com.bsp.oauth2.authorization.server.entity.UserPrincipal;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.MissingNode;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class UserPrincipalDeserializer extends JsonDeserializer<UserPrincipal> {

    @Override
    public UserPrincipal deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        JsonNode jsonNode = mapper.readTree(jp);
        final JsonNode authoritiesNode = readJsonNode(jsonNode, "authorities");
        Set<UserAuthority> userAuthorities = getUserAuthorities(mapper, authoritiesNode);

        Long id = readJsonNode(jsonNode, "id").asLong();
        String username = readJsonNode(jsonNode, "username").asText();
        JsonNode passwordNode = readJsonNode(jsonNode, "password");
        String password = passwordNode.asText("");
        // boolean enabled = readJsonNode(jsonNode, "enabled").asBoolean();
        // boolean accountNonExpired = readJsonNode(jsonNode, "accountNonExpired").asBoolean();
        // boolean credentialsNonExpired = readJsonNode(jsonNode, "credentialsNonExpired").asBoolean();
        // boolean accountNonLocked = readJsonNode(jsonNode, "accountNonLocked").asBoolean();
        // final JsonNode auditNode = readJsonNode(jsonNode, "audit");

        UserPrincipal userPrincipal = UserPrincipal.builder().id(id).username(username).password(password).build();
        if (passwordNode.asText(null) == null) {
            userPrincipal.eraseCredentials();
        }

        return userPrincipal;

    }

    private JsonNode readJsonNode(JsonNode jsonNode, String field) {
        return jsonNode.has(field) ? jsonNode.get(field) : MissingNode.getInstance();
    }

    private Set<UserAuthority> getUserAuthorities(final ObjectMapper mapper, final JsonNode authoritiesNode) throws JsonParseException, JsonMappingException, IOException {

        Set<UserAuthority> userAuthorities = new HashSet<>();
        if (authoritiesNode != null) {
            if (authoritiesNode.isArray()) {
                for (final JsonNode objNode : authoritiesNode) {
                    if (objNode.isArray()) {
                        ArrayNode arrayNode = (ArrayNode) objNode;
                        for (JsonNode elementNode : arrayNode) {
                            UserAuthority userAuthority = mapper.readValue(elementNode.traverse(mapper), UserAuthority.class);
                            userAuthorities.add(userAuthority);
                        }
                    }
                }
            }
        }
        return userAuthorities;
    }

}
