<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>MongoDb Login Servlet</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
    <!-- Pooper & Bootstrap js/css File -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <link rel="stylesheet" href="https://bootswatch.com/4/flatly/bootstrap.min.css">
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
      integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
      integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
      crossorigin="anonymous"
   	></script>
   	 
    <!-- jQuery Files -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!--<script type="text/javascript" src="resource/js/form_login.js"></script>-->
</head>
<body>
<div class="row justify-content-center">
    <div class="col mt-3">
        <div class="card" id="biometricOperationCard">
            <form asp-controller="Home" asp-action="Uui" method="post" class="form-horizontal" role="form" id="uuiForm">
                <h4 class="card-header text-white" style="background-color:#465c7b!important">
                    BioID Verification
                </h4>
                <div class="card-body">
                    <div class="d-xl-none">
                        <p>Perform one of the standard biometric operations using the <strong>BWS unified user interface</strong> (UUI).</p>
                    </div>
                    <div class="row">
                        <div class="order-1 order-sm-0 col col-sm-6 col-xl-8">
                            <div class="d-none d-xl-block">
                                <p>Perform one of the standard biometric operations using the <strong>BWS unified user interface</strong> (UUI).</p>
                            </div>
                            <div class="form-group">
                                <div><strong>Login Email</strong></div>
                                <input type="text" class="form-control" name="bcid" value=${bcid} disabled/>
                            </div>
                            <div class="form-group">
                                <div><strong>Operation</strong></div>
                                <div class="custom-control custom-radio my-1">
                                    <input type="radio" class="custom-control-input" name="operation" id="enrollment" value="enroll">
                                    <label class="custom-control-label" for="enrollment">Enrollment</label>
                                    <a tabindex="0" role="button" data-toggle="popover" data-trigger="hover focus" title="Biometric enrollment" data-html="false"
                                       data-content="Before anything else you first have to enroll, i.e. you have to record images of your face (or a repetition of an utterance) and use these recordings to create your biometric template.">
                                        <i class="fa fa-question-circle-o text-info"></i>
                                    </a>
                                </div>
                                <div class="custom-control custom-radio my-1">
                                    <input type="radio" class="custom-control-input" name="operation" id="verification" value="verify" checked>
                                    <label class="custom-control-label" for="verification">Login Verification</label>
                                    <a tabindex="0" role="button" data-toggle="popover" data-trigger="hover focus" title="Biometric verification" data-html="false"
                                       data-content="For verification you upload one or more face images. Our service compares features of the samples with your biometric template to recognize you. You must be enrolled first - otherwise you'll encounter an error message.">
                                        <i class="fa fa-question-circle-o text-info"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="form-group">
                                <div><strong>Options</strong></div>
                                <div class="custom-control custom-checkbox my-1">
                                    <input type="checkbox" class="custom-control-input" name="Face" id="facetrait" value="true" checked>
                                    <label class="custom-control-label" for="facetrait">Use face trait</label>
                                    <a tabindex="0" role="button" data-toggle="popover" data-trigger="hover focus" title="Multimodal biometrics" data-html="false"
                                       data-content="Perform the biometric operation with the selected traits. Multimodal biometrics, i.e. using more than one trait, increases security and accuracy. At least 'Face' or 'Periocular' need to be selected! ('Voice' is not yet supported as the BioID unified user interface is not yet capable of recording voice data.)">
                                        <i class="fa fa-question-circle-o text-info"></i>
                                    </a>
                                </div>
                                <div class="custom-control custom-checkbox my-1">
                                    <input type="checkbox" class="custom-control-input" name="Periocular" id="perioculartrait" value="true" checked>
                                    <label class="custom-control-label" for="perioculartrait">Use periocular trait</label>
                                    <a tabindex="0" role="button" data-toggle="popover" data-trigger="hover focus" title="Eye biometrics" data-html="false"
                                       data-content="The periocular trait differs from the face trait in that it looks only at the fine features around around the eye, such as lashes, lid, brow, and folds in the skin, as well as full or partial iris (the complex patterns on the colored part of the eye). Unlike face, the mouth and nose do not need to be visible, so it is ideal for applications where the face is partially covered by a medical mask, scarf or veil.">
                                        <i class="fa fa-question-circle-o text-info"></i>
                                    </a>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-success mt-4">Perform operation</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>