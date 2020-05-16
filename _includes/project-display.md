{% if page.parent_name %}
##### [Return to {{ page.parent_name }}]( {{ '/repo_projects/' | append: page.parent_name '/' | relative_url}})
{% else %}
##### [Return to Documentation](/documentation/)
{% endif %}

## {{ page.display_name }}

{{ page.description }}

{% if page.files %}

### Files

{% for file in page.files %}

[{{ file }}]({{ site.aperture.raw-url }}{{ file }})

{% endfor %}

{% endif %}

{% if page.projects %}

### Sub Modules:

{% for project in page.projects %}

{% assign sub_module = site.repo_projects | where: "display_name", project | first %}

#### [{{ sub_module.display_name }}]({{ sub_module.display_name | prepend: 'repo_projects/' | relative_url }})

{% if sub_module.description %}

{{ sub_module.description }}

{% endif %}

{% endfor %}

{% endif %}