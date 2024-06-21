<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">
html { height: 100% }
body { height: 100%; margin: 0; padding: 0 }
#carteId { height: 100% }
</style>
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">
function initialize() {
    var mapOptions = {
        center: new google.maps.LatLng(-18.986021, 47.532735),
        zoom: 15
    };
    var carte = new google.maps.Map(document.getElementById("carteId"), mapOptions);

}

google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>
<body>
<div id="carteId"></div>
</body>
</html>
