<div class="progress">
    <g:set var="colorClass" value="progress-bar-success"/>
    <g:if test="${percentage == 100}">
        <g:set var="colorClass" value="progress-bar-danger"/>
    </g:if>
    <div class="progress-bar ${colorClass}" role="progressbar" aria-valuenow="${percentage}" aria-valuemin="0" aria-valuemax="100" style="width: ${percentage}%;">
        <span class="sr-only">${percentage}% Complete</span>
    </div>
</div>