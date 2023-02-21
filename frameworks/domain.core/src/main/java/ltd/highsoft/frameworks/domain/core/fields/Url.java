package ltd.highsoft.frameworks.domain.core.fields;

import static ltd.highsoft.frameworks.domain.core.fields.DomainFieldRule.StringThing.string;

public final class Url extends GeneralInformation {

    public Url(String url) {
        super(url);
        final var urlRegex = "^([h][t]{2}[p]://|[h][t]{2}[p][s]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\\\\\\\/])+$";
        addRule(string().regex(urlRegex, "error.url-not-match-format"));
    }

}
