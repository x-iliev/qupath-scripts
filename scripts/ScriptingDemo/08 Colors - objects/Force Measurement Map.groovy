// Original source https://forum.image.sc/t/problem-running-script-from-publication/35542/7
// To undo this color change, open Measure-> Show measurement maps, select a measurement, and then close the dialog box.

// Choose one of them
def colorMapper = MeasurementMapper.loadDefaultColorMaps().find {it.getName() == 'Inferno'}

// Create a measurement mapper
def detections = getDetectionObjects()
def measurementMapper = new MeasurementMapper(colorMapper, 'Subcellular: Eosin: Num spots estimated', detections)

// Show the measurement mapper in the current viewer
def viewer = getCurrentViewer()
def overlayOptions = viewer.getOverlayOptions()
overlayOptions.setMeasurementMapper(measurementMapper)

import qupath.lib.gui.tools.*