package org.elasticsearch.plugin.analysis.hangueljamo;

import static java.util.Collections.singletonMap;

import java.util.HashMap;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.elasticsearch.index.analysis.AnalyzerProvider;
import org.elasticsearch.index.analysis.HanguelJamoMorphTokenizerFactory;
import org.elasticsearch.index.analysis.HanguelJamoMorphAnalyzerProvider;
import org.elasticsearch.index.analysis.HanguelJamoMorphTokenFilterFactory;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.index.analysis.TokenizerFactory;
import org.elasticsearch.indices.analysis.AnalysisModule.AnalysisProvider;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;


public class AnalysisHanguelJamoPlugin extends Plugin implements AnalysisPlugin {
//
//    @Override
//    public String name() {
//        return "analysis-hangueljamo";
//    }
//
//    @Override
//    public String description() {
//        return "Hanguel Jamo Analyzer";
//    }
//
//    public void onModule(AnalysisModule module) {
//        module.addProcessor(new HanguelJamoMorphAnalysisBinderProcessor());
//    }
//}

    @Override
    public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        return singletonMap("arirangmao_filter", HanguelJamoMorphTokenFilterFactory::new);
    }

    @Override
    public Map<String, AnalysisProvider<TokenizerFactory>> getTokenizers() {
        Map<String, AnalysisProvider<TokenizerFactory>> extra = new HashMap<>();
        extra.put("hangueljamo_tokenizer", HanguelJamoMorphTokenizerFactory::new);

        return extra;
    }

    @Override
    public Map<String, AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        return singletonMap("hangueljamo_analyzer", HanguelJamoMorphAnalyzerProvider::new);
    }
}