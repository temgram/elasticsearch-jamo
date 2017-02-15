package org.elasticsearch.index.analysis;

import org.apache.lucene.analysis.Tokenizer;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.IndexSettings;
import org.gruter.analysis.hanguel.morph.HanguelJamoMorphTokenizer;

public class HanguelJamoMorphTokenizerFactory extends AbstractTokenizerFactory {

    @Inject
    public HanguelJamoMorphTokenizerFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, name, settings);
    }

    @Override
    public Tokenizer create() {
        return new HanguelJamoMorphTokenizer();
    }
}