package com.sbm.scraper.controller;

import com.sbm.scraper.endpoint.ElementScraperEndpoint;
import com.sbm.scraper.model.ElementCriteria;
import com.sbm.validator.builders.ValidatorBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ElementScraperController implements ElementScraperEndpoint {

    @Override
    public List<String> getElements(ElementCriteria criteria) {
        if (criteria.getUrl() == null) {
            return null;
        }
        try {
            Document document = Jsoup.connect(criteria.getUrl()).get();
            if (criteria.getId() != null) {
                List<Element> elementById = document.getElementsByAttributeValue("id", criteria.getId());
                if (elementById != null) {
                    return filterElements(elementById, criteria);
                }
                return null;
            } else if (criteria.getClassNames() != null) {
                List<Element> elementsByClassNames = new ArrayList<>();
                criteria.getClassNames().forEach((c) -> elementsByClassNames.addAll(document.getElementsByClass(c)));
                return filterElements(elementsByClassNames, criteria);
            } else if (criteria.getAttributes() != null) {
                List<Element> elementsByAttributes = document.getElementsByAttribute(criteria.getTagName());
                return filterElements(elementsByAttributes, criteria);
            } else if (criteria.getTagName() != null) {
                List<Element> elementsByTagName = document.getElementsByTag(criteria.getTagName());
                return filterElements(elementsByTagName, criteria);
            }
        } catch (final IOException ex) {
            // TODO: Error handling. Log exception
        }
        return null;
    }

    private boolean passCriteriaCheck(Element element, ElementCriteria criteria) {
        ValidatorBuilder validator = ValidatorBuilder.create();
        if (criteria.getId() != null) {
            validator.isEqualToString(element.attr("id"), criteria.getId());
        }
        if (criteria.getTagName() != null) {
            validator.isEqualToString(element.tagName(), criteria.getTagName());
        }
        if (criteria.getClassNames() != null) {
            criteria.getClassNames().forEach((c) -> validator.test(c, element::hasClass));
        }
        if (criteria.getAttributes() != null) {
            criteria.getAttributes().forEach((k,v) ->
                    validator.isEqualToString(element.attributes().getIgnoreCase(k), v));
        }
        return ValidatorBuilder.isValid();
    }

    private List<String> filterElements(List<Element> elements, ElementCriteria criteria) {
        if (elements != null) {
            return elements.stream().filter(e ->
                    passCriteriaCheck(e, criteria)).map(Node::outerHtml).collect(Collectors.toList());
        }
        return null;
    }

}
