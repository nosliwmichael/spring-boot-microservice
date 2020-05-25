{% if page.parent_name %}
##### [Return to {{ page.parent_name }}]( {{ '/repo_projects/' | append: page.parent_name '/' | downcase | relative_url}})
{% else %}
##### [Return to Documentation]({{ '/documentation/' | relative_url }})
{% endif %}

## {{ page.display_name }}

{{ page.description }}

{% if page.files %}

### Files

{% for file in page.files %}
{% if file.path %}
[{{ file.name }}]({{ site.aperture.raw-url | append: site.aperture.branch }}/{{ page.app_path | append: file.path | append: file.name }})
{% else %}
[{{ file.name }}]({{ site.aperture.raw-url | append: site.aperture.branch }}/{{ page.app_path | append: file.name }})
{% endif %}

{% endfor %}

{% endif %}

{% if page.projects %}

### Sub Modules:

{% for project in page.projects %}

{% assign sub_module = site.repo_projects | where: "display_name", project | first %}

#### [{{ sub_module.display_name }}]({{ sub_module.display_name | downcase | prepend: 'repo_projects/' | relative_url }})

{% if sub_module.description %}

{{ sub_module.description }}

{% endif %}

{% endfor %}

{% endif %}