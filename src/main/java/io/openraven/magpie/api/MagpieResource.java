/*-
 * #%L
 * Magpie API
 * %%
 * Copyright (C) 2021 Open Raven Inc
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package io.openraven.magpie.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.openraven.magpie.api.utils.EncodedNamedUUIDGenerator;

import java.time.Instant;

public class MagpieResource {
  private final ObjectMapper mapper;
  public String assetId;
  public String resourceName;
  public String resourceId;
  public String resourceType;
  public String region;
  public String projectId;
  public String accountId;
  public Instant createdIso;
  public Instant updatedIso = Instant.now();
  public String discoverySessionId;
  public Long maxSizeInBytes = null;
  public Long sizeInBytes = null;

  public JsonNode configuration;
  public JsonNode supplementaryConfiguration;
  public JsonNode tags;
  public JsonNode discoveryMeta;

  private MagpieResource(MagpieResourceBuilder builder) {
    this.assetId = builder.assetId;
    this.resourceName = builder.resourceName;
    this.resourceId = builder.resourceId;
    this.resourceType = builder.resourceType;
    this.region = builder.region;
    this.projectId = builder.projectId;
    this.accountId = builder.accountId;
    this.createdIso = builder.createdIso;
    this.updatedIso = builder.updatedIso;
    this.discoverySessionId = builder.discoverySessionId;
    this.maxSizeInBytes = builder.maxSizeInBytes;
    this.sizeInBytes = builder.sizeInBytes;
    this.configuration = builder.configuration;
    this.supplementaryConfiguration = builder.supplementaryConfiguration;
    this.tags = builder.tags;
    this.discoveryMeta = builder.discoveryMeta;
    this.mapper = builder.mapper;
  }

  public ObjectNode toJsonNode() {
    var data = mapper.createObjectNode();

    data.put("documentId", EncodedNamedUUIDGenerator.getEncodedNamedUUID(assetId));
    data.put("assetId", assetId);
    data.put("resourceName", resourceName);
    data.put("resourceId", resourceId);
    data.put("resourceType", resourceType);
    data.put("region", region);
    data.put("accountId", accountId);
    data.put("projectId", projectId);
    data.put("createdIso", createdIso == null ? null : createdIso.toString());
    data.put("updatedIso", updatedIso == null ? null : updatedIso.toString());
    data.put("discoverySessionId", discoverySessionId);
    data.put("maxSizeInBytes", maxSizeInBytes);
    data.put("sizeInBytes", sizeInBytes);

    data.set("configuration", configuration);
    data.set("supplementaryConfiguration", supplementaryConfiguration);
    data.set("tags", tags);
    data.set("discoveryMeta", discoveryMeta);

    return data;
  }

  public String getAssetId() {
    return assetId;
  }

  public void setAssetId(String assetId) {
    this.assetId = assetId;
  }

  public String getResourceName() {
    return resourceName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }

  public String getResourceId() {
    return resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  public String getResourceType() {
    return resourceType;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public Instant getCreatedIso() {
    return createdIso;
  }

  public void setCreatedIso(Instant createdIso) {
    this.createdIso = createdIso;
  }

  public Instant getUpdatedIso() {
    return updatedIso;
  }

  public void setUpdatedIso(Instant updatedIso) {
    this.updatedIso = updatedIso;
  }

  public String getDiscoverySessionId() {
    return discoverySessionId;
  }

  public void setDiscoverySessionId(String discoverySessionId) {
    this.discoverySessionId = discoverySessionId;
  }

  public Long getMaxSizeInBytes() {
    return maxSizeInBytes;
  }

  public void setMaxSizeInBytes(Long maxSizeInBytes) {
    this.maxSizeInBytes = maxSizeInBytes;
  }

  public Long getSizeInBytes() {
    return sizeInBytes;
  }

  public void setSizeInBytes(Long sizeInBytes) {
    this.sizeInBytes = sizeInBytes;
  }

  public JsonNode getConfiguration() {
    return configuration;
  }

  public void setConfiguration(JsonNode configuration) {
    this.configuration = configuration;
  }

  public JsonNode getSupplementaryConfiguration() {
    return supplementaryConfiguration;
  }

  public void setSupplementaryConfiguration(JsonNode supplementaryConfiguration) {
    this.supplementaryConfiguration = supplementaryConfiguration;
  }

  public JsonNode getTags() {
    return tags;
  }

  public void setTags(JsonNode tags) {
    this.tags = tags;
  }

  public JsonNode getDiscoveryMeta() {
    return discoveryMeta;
  }

  public void setDiscoveryMeta(JsonNode discoveryMeta) {
    this.discoveryMeta = discoveryMeta;
  }

  public static class MagpieResourceBuilder {
    private final ObjectMapper mapper;
    private String assetId;
    private String resourceName;
    private String resourceId;
    private String resourceType;
    private String region;
    private String projectId;
    private String accountId;
    private Instant createdIso;
    private Instant updatedIso = Instant.now();
    private String discoverySessionId;
    private Long maxSizeInBytes = null;
    private Long sizeInBytes = null;
    private JsonNode configuration;
    private JsonNode supplementaryConfiguration;
    private JsonNode tags;
    private JsonNode discoveryMeta;

    public MagpieResourceBuilder(ObjectMapper mapper, String assetId) {
      this.assetId = assetId;
      this.mapper = mapper;

      this.configuration = mapper.createObjectNode();
      this.supplementaryConfiguration = mapper.createObjectNode();
      this.tags = mapper.createObjectNode();
      this.discoveryMeta = mapper.createObjectNode();
    }

    public MagpieResourceBuilder withResourceName(String resourceName) {
      this.resourceName = resourceName;
      return this;
    }

    public MagpieResourceBuilder withResourceId(String resourceId) {
      this.resourceId = resourceId;
      return this;
    }

    public MagpieResourceBuilder withResourceType(String resourceType) {
      this.resourceType = resourceType;
      return this;
    }

    public MagpieResourceBuilder withRegion(String region) {
      this.region = region;
      return this;
    }

    public MagpieResourceBuilder withProjectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    public MagpieResourceBuilder withAccountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    public MagpieResourceBuilder withCreatedIso(Instant createdIso) {
      this.createdIso = createdIso;
      return this;
    }

    public MagpieResourceBuilder withUpdatedIso(Instant updatedIso) {
      this.updatedIso = updatedIso;
      return this;
    }

    public MagpieResourceBuilder withDiscoverySessionId(String discoverySessionId) {
      this.discoverySessionId = discoverySessionId;
      return this;
    }

    public MagpieResourceBuilder withMaxSizeInBytes(Long maxSizeInBytes) {
      this.maxSizeInBytes = maxSizeInBytes;
      return this;
    }

    public MagpieResourceBuilder withSizeInBytes(Long sizeInBytes) {
      this.sizeInBytes = sizeInBytes;
      return this;
    }

    public MagpieResourceBuilder withConfiguration(JsonNode configuration) {
      this.configuration = configuration;
      return this;
    }

    public MagpieResourceBuilder withSupplementaryConfiguration(JsonNode supplementaryConfiguration) {
      this.supplementaryConfiguration = supplementaryConfiguration;
      return this;
    }

    public MagpieResourceBuilder withTags(JsonNode tags) {
      this.tags = tags;
      return this;
    }

    public MagpieResourceBuilder withDiscoveryMeta(JsonNode discoveryMeta) {
      this.discoveryMeta = discoveryMeta;
      return this;
    }

    public MagpieResource build() {
      return new MagpieResource(this);
    }
  }
}
