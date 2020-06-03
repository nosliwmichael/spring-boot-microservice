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
<a class="code-link" href="{{ site.repo.raw-url | append: site.repo.branch }}/{{ page.app_path | append: file.path | append: file.name }}">
    {{ file.name }}
</a>
{% else %}
<a class="code-link" href="{{ site.repo.raw-url | append: site.repo.branch }}/{{ page.app_path | append: file.name }}">
    {{ file.name }}
</a>
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

{% include code-modal.html %}