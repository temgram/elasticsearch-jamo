package org.elasticsearch.index.analysis;

import org.apache.lucene.analysis.TokenStream;
import org.gruter.analysis.hanguel.morph.HanguelJamoMorphTokenFilter;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;

public class HanguelJamoMorphTokenFilterFactory extends AbstractTokenFilterFactory {

	public HanguelJamoMorphTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, name, settings);

    }

	//TODO:filter 재정
    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new HanguelJamoMorphTokenFilter(tokenStream);
    }
}
