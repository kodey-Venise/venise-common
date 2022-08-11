package me.venise.core.text.replacer;

import me.venise.core.lang.Chain;
import me.venise.core.lang.StrBuilder;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/29 10:55
 */
public class ReplacerChain extends StringReplacer implements Chain<StringReplacer, ReplacerChain> {
    private static final long serialVersionUID = 1L;

    private final List<StringReplacer> replacers = new LinkedList<>();

    /**
     * 构造
     *
     * @param strReplacers 字符串替换器
     */
    public ReplacerChain(StringReplacer... strReplacers) {
        for (StringReplacer strReplacer : strReplacers) {
            addChain(strReplacer);
        }
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public Iterator<StringReplacer> iterator() {
        return replacers.iterator();
    }

    @Override
    public ReplacerChain addChain(StringReplacer element) {
        replacers.add(element);
        return this;
    }

    @Override
    protected int replace(CharSequence str, int pos, StrBuilder out) {
        int consumed = 0;
        for (StringReplacer strReplacer : replacers) {
            consumed = strReplacer.replace(str, pos, out);
            if (0 != consumed) {
                return consumed;
            }
        }
        return consumed;
    }

}