// Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.intellij.ide.ui;

import com.intellij.openapi.application.Experiments;

/**
 * @author Konstantin Bulenkov
 */
public final class ExperimentalFeatureBooleanOptionDescriptor extends RegistryBooleanOptionDescriptor {
  public ExperimentalFeatureBooleanOptionDescriptor(String option, String featureId) {
    super(option, featureId);
  }

  @Override
  public boolean isOptionEnabled() {
    return Experiments.getInstance().isFeatureEnabled(myKey);
  }

  @Override
  public void setOptionState(boolean enabled) {
    Experiments.getInstance().setFeatureEnabled(myKey, enabled);
  }

  @Override
  public boolean hasChanged() {
    return Experiments.getInstance().isChanged(myKey);
  }
}