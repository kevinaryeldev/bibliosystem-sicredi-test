package br.com.kevinaryeldev.bibliosystem.runners;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("br.com.kevinaryeldev.bibliosystem")
@IncludeTags("aceitacao")
public class AceitacaoRunner {
}
